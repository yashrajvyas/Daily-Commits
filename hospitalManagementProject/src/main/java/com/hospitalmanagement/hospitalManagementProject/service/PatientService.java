package com.hospitalmanagement.hospitalManagementProject.service;

import com.hospitalmanagement.hospitalManagementProject.entity.PatientEntity;
import com.hospitalmanagement.hospitalManagementProject.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){
        PatientEntity p1 = patientRepository.findById(1L).orElse(null);
        PatientEntity p2 = patientRepository.findById(1L).orElse(null);
        System.out.println((p1 +" "+ p2));
        System.out.println(p1 == p2);
    }

    @Transactional
    public void deletePatient(Long id){
        patientRepository.findById(id).orElseThrow();
        patientRepository.deleteById(id);
    }
}



