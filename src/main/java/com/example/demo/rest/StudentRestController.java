package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentErrorResponse;
import com.example.demo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void createStudentData(){
        Student student1 = new Student();
        student1.setFirstName("Nithesh");
        student1.setEmail("nithesh@yahoo.com");
        studentList.add(student1);
        Student student2 = new Student();
        student2.setFirstName("Robert");
        student2.setEmail("robert@yahoo.com");
        studentList.add(student2);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId<0 || studentId>studentList.size())
            throw new StudentNotFoundException("Student data not found for ID: "+studentId);
        return studentList.get(studentId);
    }


}
