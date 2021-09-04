package com.smc.smcbackend.service.impl;

import com.smc.smcbackend.model.Consultation;
import com.smc.smcbackend.repository.ConsultationRepository;
import com.smc.smcbackend.service.ConsultationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository){
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Consultation createConsultation(Consultation consultation) {
        return this.consultationRepository.save(consultation);
    }
}
