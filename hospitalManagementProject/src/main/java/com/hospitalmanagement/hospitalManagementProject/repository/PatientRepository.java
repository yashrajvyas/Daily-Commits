package com.hospitalmanagement.hospitalManagementProject.repository;

import com.hospitalmanagement.hospitalManagementProject.dto.BloodGroupStats;
import com.hospitalmanagement.hospitalManagementProject.dto.CPatientInfo;
import com.hospitalmanagement.hospitalManagementProject.dto.PatientInfo;
import com.hospitalmanagement.hospitalManagementProject.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    @Query("select new com.hospitalmanagement.hospitalManagementProject.dto.CPatientInfo (p.id, p.name) " +
            "from PatientEntity p")
    List<PatientInfo> getAllPatientsInfo();

    @Query("select p.id, p.name from PatientEntity p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

   @Query("select new com.hospitalmanagement.hospitalManagementProject.dto.BloodGroupStats (p.bloodGroup, " +
           "COUNT(p)) from PatientEntity p group by p.bloodGroup order by count(p) DESC")
   List<BloodGroupStats> getBloodGroupStats();

   @Transactional
   @Modifying
   @Query("UPDATE PatientEntity p set p.name = :name where p.id = id")
   int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

   @Query("select p from PatientEntity p LEFT JOIN FETCH p.appointments")
   List<PatientEntity> getAllPatientsWithAppointments();

}
