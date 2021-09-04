package com.smc.smcbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultation {
    @Id
    private String id;
    private String patientId;
    private String date;
    private List<String> medicalConditions;
    private List<String> tests;
    private List<String> medicines;
    private String notes;
}
