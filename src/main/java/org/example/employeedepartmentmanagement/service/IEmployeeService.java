package org.example.employeedepartmentmanagement.service;

import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(String search, Pageable pageable);

    EmployeeDTO findById(Long id);

    void save(EmployeeDTO employeeDTO);

    void deleteById(Long id);
}