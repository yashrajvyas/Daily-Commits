package com.hospitalmanagement.hospitalManagementProject;

import com.hospitalmanagement.hospitalManagementProject.entity.Appointment;
import com.hospitalmanagement.hospitalManagementProject.entity.Insurance;
import com.hospitalmanagement.hospitalManagementProject.service.AppointmentService;
import com.hospitalmanagement.hospitalManagementProject.service.InsuranceService;
import com.hospitalmanagement.hospitalManagementProject.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC ERGO")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);

        //patientService.deletePatient(1L);
        var patient = insuranceService.removeInsuranceOfPatient(1L);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 11, 1, 14, 0))
                .reason("cancer")
                .build();

       var updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }
}
