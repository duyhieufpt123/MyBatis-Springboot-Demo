package com.example.demo.mapper;

import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("SELECT * FROM Teacher")
    public List<Teacher> getAllTeachers();
}
