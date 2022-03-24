package fr.jgrand.springrandomdrawapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", sequenceName = "student_seq", allocationSize = 1)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "student")
    private List<Speech> speechesList;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonIgnore
    public List<Speech> getSpeechesList() {
        return speechesList;
    }
}
