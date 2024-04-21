package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);//to save the data to DB
        System.out.println("Student saved to DB: "+student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudents() {
        //create a query
        Query theQuery = entityManager.createQuery("from Student order by lastName desc");
        //get result list
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        Query theQuery = entityManager.createQuery("from Student where lastName=:theData");
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
