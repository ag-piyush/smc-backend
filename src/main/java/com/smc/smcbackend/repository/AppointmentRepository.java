package com.smc.smcbackend.repository;

import com.smc.smcbackend.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {}
