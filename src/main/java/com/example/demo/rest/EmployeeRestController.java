package com.example.demo.rest;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> findAllEmployee(){

        return new ResponseEntity<>(EmployeeMapper.INSTANCE.modelsToDTOs(employeeService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId){
        return new ResponseEntity<>(EmployeeMapper.INSTANCE.modelToDTO(employeeService.findById(employeeId)), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return new ResponseEntity<>(dbEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer employeeId){
        employeeService.delete(employeeId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
