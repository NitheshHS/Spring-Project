package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "salaryDetails", ignore = true)
    EmployeeDTO modelToDTO(Employee employee);

    @Mapping(source = "salaryDetails", target = "salary")
    Employee dtoToModel(EmployeeDTO employeeDTO);

    @Mapping(target = "salaryDetails", ignore = true)
    List<EmployeeDTO> modelsToDTOs(List<Employee> employeeList);

}

