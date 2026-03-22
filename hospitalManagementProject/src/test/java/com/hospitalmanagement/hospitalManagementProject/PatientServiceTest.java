package com.hospitalmanagement.hospitalManagementProject;

import com.hospitalmanagement.hospitalManagementProject.entity.PatientEntity;
import com.hospitalmanagement.hospitalManagementProject.repository.PatientRepository;
import com.hospitalmanagement.hospitalManagementProject.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient() {
        //List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
        // List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();

        //for(BloodGroupStats p: patientList){
        // System.out.println(p);
        // }
        // }
        //int rowsAffected = patientRepository.updatePatientNameWithId("Yash Vyas", 1L);
        //System.out.println(rowsAffected);
        //patientService.testPatientTransaction();

        List<PatientEntity> patientEntityList = patientRepository.findAll();

        for(var p: patientEntityList){
            System.out.println(p);
        }
    }
}
