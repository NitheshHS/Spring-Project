package com.example.demo.dao;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.NoEmployeeDataInDBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //get all employee
        List<Employee> employeeList = theQuery.getResultList();
        //add exception handler
        if(employeeList.size()==0) throw new NoEmployeeDataInDBException("No Employee Data in DB!");
        //return list
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(Objects.isNull(employee))
            throw new NoEmployeeDataInDBException.EmployeeNotFoundException("Employee Data not exist for id: "+id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findById(id);
        if(employee==null)
            throw new NoEmployeeDataInDBException("No Employee with id: "+id);
        entityManager.remove(employee);
    }
}
