package org.example.employeedepartmentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.example.employeedepartmentmanagement.repository.IEmployeeRepository;
import org.example.employeedepartmentmanagement.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}