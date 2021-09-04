package com.smc.smcbackend.service.impl;

import com.smc.smcbackend.model.Patient;
import com.smc.smcbackend.repository.PatientRepository;
import com.smc.smcbackend.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

  private final PatientRepository patientRepository;

  @Autowired
  public PatientServiceImpl(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Override
  public Patient findById(String id) {
    Optional<Patient> optionalPatient = this.patientRepository.findById(id);

    if (!optionalPatient.isPresent()) {
      log.debug("No patient found for this id: {}", id);
      return null;
    }
    return optionalPatient.get();
  }

  @Override
  public List<Patient> findAll() {
    return this.patientRepository.findAll();
  }

  @Override
  public Patient savePatient(Patient patient) {
    return this.patientRepository.save(patient);
  }

  @Override
  public void deletePatient(String id) {
    this.patientRepository.deleteById(id);
  }
}
