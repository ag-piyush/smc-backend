package com.smc.smcbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "appointment")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "patient_id", nullable = false)
  private Patient patient;

  @Column(name = "date")
  private String date;

  @Column(name = "medical_conditions")
  private String medicalConditions;

  @Column(name = "medical_tests")
  private String medicalTests;

  @Column(name = "medicines")
  private String medicines;

  @Column(name = "notes")
  private String notes;
  //ToDo: Per day all appointments
}
