package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
     void save(Student student);
     Student findById(Integer id);

     List<Student> findAllStudents();

     List<Student> findStudentByLastName(String lastName);

     Student update(Student student);

     void delete(int id);
}
