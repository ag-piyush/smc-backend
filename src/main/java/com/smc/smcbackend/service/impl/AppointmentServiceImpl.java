package com.smc.smcbackend.service.impl;

import com.smc.smcbackend.model.Appointment;
import com.smc.smcbackend.model.Consultation;
import com.smc.smcbackend.model.Patient;
import com.smc.smcbackend.repository.AppointmentRepository;
import com.smc.smcbackend.service.AppointmentService;
import com.smc.smcbackend.service.ConsultationService;
import com.smc.smcbackend.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final ConsultationService consultationService;
  private final PatientService patientService;

  @Autowired
  AppointmentServiceImpl(
      AppointmentRepository appointmentRepository,
      ConsultationService consultationService,
      PatientService patientService) {
    this.appointmentRepository = appointmentRepository;
    this.consultationService = consultationService;
    this.patientService = patientService;
  }

  @Override
  public Appointment createAppointment(String patientId, String date) {

    Patient patient = this.patientService.findById(patientId);
    if (patient == null) {
      log.info("Patient is null!");
      return null;
    }

    log.info("Patient isn't null!");

    log.info("Creating consultation!");
    Consultation consultation = Consultation.builder().patientId(patientId).date(date).build();
    log.info("Saving consultation!");
    consultation = this.consultationService.createConsultation(consultation);

    log.info("Consultation created with id {}", consultation.getId());

    if (patient.getConsultationIds() == null) {
      log.info("Patient Consultation List empty!");
      List<String> consultationIds = new ArrayList<>();
      log.info("Creating empty consultation list!");
      patient.setConsultationIds(consultationIds);
      log.info("Created empty consultation list!");
    }

    log.info("Adding consultation id!");
    patient.getConsultationIds().add(consultation.getId());

    log.info("Consultation id added!");

    log.info("Saving patient to repository!");
    patient = this.patientService.savePatient(patient);

    log.info("Creating appointment!");
    Appointment appointment =
        Appointment.builder()
            .patientId(patient.getId())
            .consultationId(consultation.getId())
            .date(date)
            .build();

    return this.appointmentRepository.save(appointment);
  }
}
