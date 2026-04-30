package org.example.employeedepartmentmanagement.repository;

import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
