package com.example.demo.service.impl;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentMapper.getAllStudents();
        return students;
    }

    @Override
    public ResponseEntity<?> getStudentById(int studentId ) {
        Student student = studentMapper.getStudentById(studentId);
        if (student == null){
            throw new RuntimeException("User not found");
        }
        return ResponseEntity.ok().body(student);
    }

    @Override
    public ResponseEntity<?> createStudent(Student student) {
        List<Student> existingStudent = studentMapper.findStudentByName(student.getStudentName());
            if (existingStudent.isEmpty()) {
                Student newStudent = new Student(student.getStudentId(), student.getStudentName(), student.getStudentAddress());
                int studentId = studentMapper.createStudent(newStudent);
                Student savedStudent = studentMapper.getStudentById(studentId);
                return ResponseEntity.ok().body(newStudent);
            } else {
                throw new RuntimeException("Student with this name is already exist");
            }

        }
    @Override
    public ResponseEntity<?> updateStudent(int studentId, Student student) {
        Student existStudent = studentMapper.getStudentById(studentId);
        if (existStudent == null){
            throw new RuntimeException("Student not found");
        } else {
            existStudent.setStudentName(student.getStudentName());
            existStudent.setStudentAddress(student.getStudentAddress());
            studentMapper.updateStudentById(studentId, existStudent);
        }
        return ResponseEntity.ok().body(existStudent);
    }

    @Override
    public ResponseEntity<?> deleteStudent(int studentId) {
        Student student = studentMapper.getStudentById(studentId);
        if(student == null){
            throw new RuntimeException("Student not found");
        } else {
            studentMapper.deleteStudentById(studentId);
        }
        return ResponseEntity.ok().body("Student Deleted Sucessfully");
    }
}
