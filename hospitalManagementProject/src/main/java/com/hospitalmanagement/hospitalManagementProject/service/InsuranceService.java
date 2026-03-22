package com.hospitalmanagement.hospitalManagementProject.service;

import com.hospitalmanagement.hospitalManagementProject.entity.Insurance;
import com.hospitalmanagement.hospitalManagementProject.entity.PatientEntity;
import com.hospitalmanagement.hospitalManagementProject.repository.InsuranceRepository;
import com.hospitalmanagement.hospitalManagementProject.repository.PatientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long id){
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow();

        patientEntity.setInsurance(insurance);
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfPatient(Insurance insurance, Long id){
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow();

        patientEntity.setInsurance(insurance);
        return insurance;
    }

    @Transactional
    public PatientEntity removeInsuranceOfPatient(Long id){
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow();

        patientEntity.setInsurance(null);
        return patientEntity;
    }
}
