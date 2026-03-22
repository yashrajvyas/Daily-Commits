package com.hospitalmanagement.hospitalManagementProject.dto;

import com.hospitalmanagement.hospitalManagementProject.entity.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
