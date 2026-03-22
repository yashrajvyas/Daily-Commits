package com.hospitalmanagement.hospitalManagementProject.repository;

import com.hospitalmanagement.hospitalManagementProject.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}