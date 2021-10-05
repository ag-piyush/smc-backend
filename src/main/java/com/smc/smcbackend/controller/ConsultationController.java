package com.smc.smcbackend.controller;

import com.smc.smcbackend.model.Consultation;
import com.smc.smcbackend.service.ConsultationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultation")
@Slf4j
public class ConsultationController {
  private final ConsultationService consultationService;

  @Autowired
  public ConsultationController(ConsultationService consultationService) {
    this.consultationService = consultationService;
  }

  @PostMapping
  public Consultation createConsultation(@RequestParam String date) {
    log.info("Inside Create Consultation!");

    Consultation consultation = new Consultation();
    consultation.setDate(date);
    log.info("Created new Consultation!");
    log.info("Saving Consultation!");
    return this.consultationService.createConsultation(consultation);
  }
}
