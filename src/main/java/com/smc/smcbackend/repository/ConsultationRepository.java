package com.smc.smcbackend.repository;

import com.smc.smcbackend.model.Consultation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
}
