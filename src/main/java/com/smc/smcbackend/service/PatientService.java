package com.smc.smcbackend.service;

import com.smc.smcbackend.model.Patient;

import java.util.List;

public interface PatientService {
  Patient findById(Integer id);

  List<Patient> findAll();

  Patient savePatient(Patient patient);

  void deletePatient(Integer id);
}
