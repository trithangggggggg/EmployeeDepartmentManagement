package org.example.employeedepartmentmanagement.repository;

import org.example.employeedepartmentmanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByDepartmentId(Long departmentId);

    Page<Employee> findAllByNameContainingIgnoreCase(String search, Pageable pageable);
}