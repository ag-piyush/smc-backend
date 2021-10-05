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
  public Appointment createAppointment(Integer patientId, String date) {

    log.info("Finding patient with id: {}", patientId);
    Patient patient = this.patientService.findById(patientId);
    if (patient == null) {
      log.info("No patient found!");
      return null;
    }

    log.info("Patient Found!");

    log.info("Creating Consultation!");
    Consultation consultation = Consultation.builder().patient(patient).appointment(null).date(date).notes(null).build();
    log.info("Saving Consultation!");
    consultation = this.consultationService.createConsultation(consultation);

    log.info("Consultation created with id {}", consultation.getId());

    log.info("Creating appointment!");
    Appointment appointment =
        Appointment.builder()
            .patient(patient)
            .consultation(consultation)
            .date(date)
            .build();

    appointment = this.appointmentRepository.save(appointment);

    log.info("Adding consultation to patient");
    if (patient.getConsultations() == null) {
      List<Consultation> consultations = new ArrayList<>();
      patient.setConsultations(consultations);
    }

    patient.getConsultations().add(consultation);

    log.info("Adding appointment to patient");
    if (patient.getAppointments() == null) {
      List<Appointment> appointments = new ArrayList<>();
      patient.setAppointments(appointments);
    }

    patient.getAppointments().add(appointment);
    log.info("Appointment added to patient!");

    log.info("Adding appointment to consultation");
    consultation.setAppointment(appointment);

    log.info("Appointment added to consultation!");
    return appointment;
  }
}
