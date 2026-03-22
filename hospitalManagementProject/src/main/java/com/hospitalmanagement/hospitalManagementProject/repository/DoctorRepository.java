package com.hospitalmanagement.hospitalManagementProject.repository;

import com.hospitalmanagement.hospitalManagementProject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

