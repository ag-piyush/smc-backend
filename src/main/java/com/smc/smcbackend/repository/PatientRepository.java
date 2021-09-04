package com.smc.smcbackend.repository;

import com.smc.smcbackend.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {}
