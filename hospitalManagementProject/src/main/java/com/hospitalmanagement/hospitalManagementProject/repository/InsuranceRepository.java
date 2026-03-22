package com.hospitalmanagement.hospitalManagementProject.repository;

import com.hospitalmanagement.hospitalManagementProject.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}