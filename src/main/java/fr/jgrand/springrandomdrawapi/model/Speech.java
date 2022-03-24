package fr.jgrand.springrandomdrawapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Speech {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speech_generator")
    @SequenceGenerator(name = "speech_generator", sequenceName = "speech_seq", allocationSize = 1)
    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne
    private Student student;

    public Speech() {
    }

    public Speech(LocalDateTime dateTime, Student student) {
        this.dateTime = dateTime;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Student getStudent() {
        return student;
    }
}
