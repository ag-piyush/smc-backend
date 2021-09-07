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
      return null;
    }

    Consultation consultation = Consultation.builder()
            .patientId(patientId)
            .date(date)
            .build();
    consultation = this.consultationService.createConsultation(consultation);

    log.info("Consultation created with id {}", consultation.getId());

    log.info("Creating appointment!");
    Appointment appointment =
            Appointment.builder()
                    .patientId(patient.getId())
                    .consultationId(consultation.getId())
                    .date(date)
                    .build();

    appointment = this.appointmentRepository.save(appointment);

    log.info("Adding consultation id to patient");
    if (patient.getConsultationIds() == null) {
      List<String> consultationIds = new ArrayList<>();
      patient.setConsultationIds(consultationIds);
    }

    patient.getConsultationIds().add(consultation.getId());

    log.info("Adding appointment id to patient");
    if (patient.getAppointmentIds() == null) {
      List<String> appointmentIds = new ArrayList<>();
      patient.setAppointmentIds(appointmentIds);
    }

    patient.getAppointmentIds().add(appointment.getId());

    log.info("Saving patient");
    this.patientService.savePatient(patient);

    return appointment;
  }
}
