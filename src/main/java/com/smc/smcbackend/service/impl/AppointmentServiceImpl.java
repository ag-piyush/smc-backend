package com.smc.smcbackend.service.impl;

import com.smc.smcbackend.model.Appointment;
import com.smc.smcbackend.model.Patient;
import com.smc.smcbackend.repository.AppointmentRepository;
import com.smc.smcbackend.service.AppointmentService;
import com.smc.smcbackend.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final PatientService patientService;

  @Autowired
  AppointmentServiceImpl(
      AppointmentRepository appointmentRepository,
      PatientService patientService) {
    this.appointmentRepository = appointmentRepository;
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

    log.info("Creating appointment!");
    Appointment appointment =
        Appointment.builder()
            .patient(patient)
            .date(date)
            .build();

    appointment = this.appointmentRepository.save(appointment);

    log.info("Adding appointment to patient");
    if (patient.getAppointments() == null) {
      List<Appointment> appointments = new ArrayList<>();
      patient.setAppointments(appointments);
    }

    patient.getAppointments().add(appointment);
    log.info("Appointment added to patient!");

    return appointment;
  }

  @Override
  public Appointment findById(Integer id) {
    Optional<Appointment> optionalAppointment = this.appointmentRepository.findById(id);

    if (!optionalAppointment.isPresent()) {
      log.debug("No appointment found for this id: {}", id);
      return null;
    }
    return optionalAppointment.get();
  }

  @Override
  public List<Appointment> findAll() {
    return this.appointmentRepository.findAll();
  }
}
