package org.example.employeedepartmentmanagement.service;

import org.example.employeedepartmentmanagement.dto.DepartmentDTO;
import org.example.employeedepartmentmanagement.entity.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findAll();

    DepartmentDTO findById(Long id);

    void save(DepartmentDTO departmentDTO);

    void deleteById(Long id);
}