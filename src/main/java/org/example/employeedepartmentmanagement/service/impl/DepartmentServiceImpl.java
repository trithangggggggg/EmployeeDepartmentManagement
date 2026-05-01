package org.example.employeedepartmentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.dto.DepartmentDTO;
import org.example.employeedepartmentmanagement.entity.Department;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.example.employeedepartmentmanagement.repository.IDepartmentRepository;
import org.example.employeedepartmentmanagement.repository.IEmployeeRepository;
import org.example.employeedepartmentmanagement.service.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;
    private final IEmployeeRepository employeeRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentDTO findById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) {
            return null;
        }

        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .location(department.getLocation())
                .build();
    }

    @Override
    public void save(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        List<Employee> employees = employeeRepository.findAllByDepartmentId(id);
        for (Employee employee : employees) {
            employee.setDepartment(null);
        }
        employeeRepository.saveAll(employees);
        departmentRepository.deleteById(id);
    }
}