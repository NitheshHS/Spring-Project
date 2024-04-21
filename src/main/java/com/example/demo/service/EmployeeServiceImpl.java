package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptions.NoEmployeeDataInDBException;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    //private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

//    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(NoEmployeeDataInDBException::new);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
