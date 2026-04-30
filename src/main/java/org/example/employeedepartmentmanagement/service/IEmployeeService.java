package org.example.employeedepartmentmanagement.service;

import org.example.employeedepartmentmanagement.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    void deleteById(Long id);
}