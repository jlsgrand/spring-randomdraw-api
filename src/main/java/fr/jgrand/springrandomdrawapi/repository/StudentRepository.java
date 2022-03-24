package fr.jgrand.springrandomdrawapi.repository;

import fr.jgrand.springrandomdrawapi.model.ISpeechCount;
import fr.jgrand.springrandomdrawapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT students.speechesList.size as speechCount, students as student FROM Student students")
    List<ISpeechCount> getStudentSpeechCount();
}
