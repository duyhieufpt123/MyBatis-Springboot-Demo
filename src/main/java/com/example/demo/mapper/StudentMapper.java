package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    int createStudent(Student student);

    List<Student> findStudentByName(String studentName);

    int updateStudentById(int studentId, Student student);

    void deleteStudentById(int studentId);
}
