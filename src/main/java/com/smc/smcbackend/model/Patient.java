package com.smc.smcbackend.model;

import com.smc.smcbackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "patient")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "age")
  private Integer age;

  @Column(name = "gender")
  private Gender gender;

//  @OneToMany(targetEntity = MedicalCondition.class, mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  private List<MedicalCondition> medicalConditions;

  @OneToMany(targetEntity = Consultation.class, mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Consultation> consultations;

  @OneToMany(targetEntity = Appointment.class, mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Appointment> appointments;

  //Todo: Patient Feedback
  //Appointment notification
}
