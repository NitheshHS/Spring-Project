package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);
}
