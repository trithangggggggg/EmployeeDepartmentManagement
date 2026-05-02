package org.example.employeedepartmentmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.entity.Department;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.example.employeedepartmentmanagement.repository.IDepartmentRepository;
import org.example.employeedepartmentmanagement.repository.IEmployeeRepository;
import org.example.employeedepartmentmanagement.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final IDepartmentRepository departmentRepository;

    @Override
    public Page<Employee> findAll(String search, Pageable pageable) {
        if (search.isEmpty()) {
            return employeeRepository.findAll(pageable);
        }

        return employeeRepository.findAllByNameContainingIgnoreCase(search, pageable);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .avatar(employee.getAvatar())
                .status(employee.getStatus())
                .departmentId(employee.getDepartment() != null ? employee.getDepartment().getId() : null)
                .build();
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Employee employee;

        if (employeeDTO.getId() != null) {
            employee = employeeRepository.findById(employeeDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
        } else {
            employee = new Employee();
        }
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setStatus(employeeDTO.getStatus());
        employee.setDepartment(department);

        MultipartFile file = employeeDTO.getFile();

        if (file != null && !file.isEmpty()) {
            try {
                String originalFileName = file.getOriginalFilename();
                String newFileName = UUID.randomUUID() + "_" + originalFileName;
                Path uploadPath = Paths.get(
                        System.getProperty("user.dir"),
                        "src",
                        "main",
                        "resources",
                        "static",
                        "images"
                );
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path destinationPath = uploadPath.resolve(newFileName);
                Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                employee.setAvatar(newFileName);
            } catch (IOException e) {
                throw new RuntimeException("Upload file failed: " + e.getMessage());
            }
        } else {
            if (employeeDTO.getId() == null) {
                employee.setAvatar(null);
            }
        }
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}