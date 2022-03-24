package fr.jgrand.springrandomdrawapi.service;

import fr.jgrand.springrandomdrawapi.model.ISpeechCount;
import fr.jgrand.springrandomdrawapi.model.Speech;
import fr.jgrand.springrandomdrawapi.model.Student;
import fr.jgrand.springrandomdrawapi.repository.SpeechRepository;
import fr.jgrand.springrandomdrawapi.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class SpeechService {

    private final SpeechRepository speechRepository;
    private final StudentRepository studentRepository;

    public SpeechService(SpeechRepository speechRepository, StudentRepository studentRepository) {
        this.speechRepository = speechRepository;
        this.studentRepository = studentRepository;
    }

    public List<Speech> getAllSpeeches() {
        return this.speechRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTime"));
    }

    public Speech getNewSpeech() {
        // On récupère la somme des tours de parole de chacun
        final List<ISpeechCount> speechesCount = studentRepository.getStudentSpeechCount();
        // On en déduit le nombre de tour minimum
        final OptionalInt minimumSpeechesCount = speechesCount.stream().mapToInt(ISpeechCount::getSpeechCount).min();

        List<Student> nextParticipantCandidates;
        if (minimumSpeechesCount.isPresent()) {
            // Si on a un minimum (ie la liste n'est pas vide), on peut créer une liste réduite de personne à tirer au sort
            nextParticipantCandidates = speechesCount
                    .stream()
                    .filter(item -> item.getSpeechCount() == minimumSpeechesCount.getAsInt())
                    .map(ISpeechCount::getStudent)
                    .collect(Collectors.toList());
        } else {
            // Sinon, on lève une exception, on ne peut pas créer de nouveau speech sans participant
            // TODO custom exception
            throw new RuntimeException("No student, cannot create a new Speech");
        }

        // On tire au sort dans la liste réduite
        final int randomIndex = (int) (Math.random() * nextParticipantCandidates.size());
        Speech newSpeech = new Speech(LocalDateTime.now(), nextParticipantCandidates.get(randomIndex));

        // On sauve le speech et on le retourne
        return speechRepository.save(newSpeech);
    }
}
