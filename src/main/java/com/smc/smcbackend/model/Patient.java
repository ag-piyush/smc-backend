package com.smc.smcbackend.model;

import com.smc.smcbackend.enums.Gender;
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
public class Patient {

  @Id private String id;
  private String name;
  private Integer age;
  private Gender gender;
  private List<String> medicalConditions;
  private List<String> consultationIds;
  private List<String> appointmentIds;
}
