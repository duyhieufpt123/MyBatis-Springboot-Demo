package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAllStudents();
    public ResponseEntity<?> getStudentById(int id);

    public ResponseEntity<?> createStudent(Student student);
    public ResponseEntity<?>  updateStudent(int studentId, Student student);

    public ResponseEntity<?> deleteStudent(int studentId);


}
