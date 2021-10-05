package com.smc.smcbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consultation")
public class Consultation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @OneToOne(targetEntity = Appointment.class, mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "appointment_id")
  private Appointment appointment;

  @Column(name = "date")
  private String date;

//  @OneToMany(targetEntity = MedicalCondition.class, mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  private List<MedicalCondition> medicalConditions;

  @OneToMany(targetEntity = MedicalTest.class, mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<MedicalTest> medicalTests;

  @OneToMany(targetEntity = Medicine.class, mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Medicine> medicines;

  @Column(name = "notes")
  private String notes;
}
