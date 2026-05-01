package org.example.employeedepartmentmanagement.service;

import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    EmployeeDTO findById(Long id);

    void save(EmployeeDTO employeeDTO);

    void deleteById(Long id);
}