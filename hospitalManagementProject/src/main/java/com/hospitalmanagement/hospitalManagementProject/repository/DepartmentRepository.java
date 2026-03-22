package com.hospitalmanagement.hospitalManagementProject.repository;

import com.hospitalmanagement.hospitalManagementProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}