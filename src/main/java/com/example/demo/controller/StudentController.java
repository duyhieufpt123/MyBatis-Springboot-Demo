package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @GetMapping("/student/")
    public ResponseEntity<?> getAllStudent() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }


    @PostMapping("/student/")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }


    @PutMapping("/student/{studentId}")
    public ResponseEntity<?> updateStudentById(@PathVariable int studentId, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(studentId, student));
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int studentId){
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }
}
