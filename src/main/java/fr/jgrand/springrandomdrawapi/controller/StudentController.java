package fr.jgrand.springrandomdrawapi.controller;

import fr.jgrand.springrandomdrawapi.model.Student;
import fr.jgrand.springrandomdrawapi.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        if (student.getId() != null && student.getId() > 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(studentRepository.save(student));
        }
    }

    // EDIT
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (student.getId() == null && student.getId() <= 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(studentRepository.save(student));
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
