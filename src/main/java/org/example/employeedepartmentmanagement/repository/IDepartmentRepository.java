package org.example.employeedepartmentmanagement.repository;

import org.example.employeedepartmentmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
}
