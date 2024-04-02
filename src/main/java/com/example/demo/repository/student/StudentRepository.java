package classy.classyapp.BackendApi.repository.student;

import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.model.user.student.Student;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentRepository {
    List<Student> findAll();
    Student findById(@Param("id") String id);
    Student findByEmail(@Param("email") String email);
    List<Student> findByName(@Param("name") String name);
    List<Student> findByStudyStatus(@Param("studyStatus") StudyStatus studyStatus);
    void update(Student student);
    Student insertStudent(Student student);

}