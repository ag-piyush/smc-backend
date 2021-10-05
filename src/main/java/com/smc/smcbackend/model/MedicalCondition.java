package com.smc.smcbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.locks.Condition;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "medicalcondition")
public class MedicalCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "condition", nullable = false)
    private String condition;

//    @ManyToOne
//    @JoinColumn(name = "consultation_id")
//    private Consultation consultation;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;
}
