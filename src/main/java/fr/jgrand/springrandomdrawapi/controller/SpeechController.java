package fr.jgrand.springrandomdrawapi.controller;

import fr.jgrand.springrandomdrawapi.model.Speech;
import fr.jgrand.springrandomdrawapi.service.SpeechService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/speeches")
@CrossOrigin("*")
public class SpeechController {

    private final SpeechService speechService;

    public SpeechController(SpeechService speechService) {
        this.speechService = speechService;
    }

    @GetMapping
    public List<Speech> getAllSpeeches() {
        return this.speechService.getAllSpeeches();
    }

    @GetMapping("/next")
    public ResponseEntity<Speech> createSpeech() {
        return ResponseEntity.ok(this.speechService.getNewSpeech());
    }
}
