package com.hospitalmanagement.hospitalManagementProject.service;

import com.hospitalmanagement.hospitalManagementProject.entity.Appointment;
import com.hospitalmanagement.hospitalManagementProject.entity.Doctor;
import com.hospitalmanagement.hospitalManagementProject.entity.PatientEntity;
import com.hospitalmanagement.hospitalManagementProject.repository.AppointmentRepository;
import com.hospitalmanagement.hospitalManagementProject.repository.DoctorRepository;
import com.hospitalmanagement.hospitalManagementProject.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment createNewAppointment(Appointment appointment, Long patient_id, Long doctor_id){
        PatientEntity patientEntity = patientRepository.findById(patient_id).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow();

        appointment.setPatientEntity(patientEntity);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }

}
