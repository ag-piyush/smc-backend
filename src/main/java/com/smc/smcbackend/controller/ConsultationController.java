package com.smc.smcbackend.controller;

import com.smc.smcbackend.model.Consultation;
import com.smc.smcbackend.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
  private final ConsultationService consultationService;

  @Autowired
  public ConsultationController(ConsultationService consultationService) {
    this.consultationService = consultationService;
  }

  @PostMapping
  public Consultation createConsultation(@RequestBody Consultation consultation) {
    return this.consultationService.createConsultation(consultation);
  }
}
