package com.smc.smcbackend.service;

import com.smc.smcbackend.model.Appointment;

import java.util.List;

public interface AppointmentService {
  Appointment createAppointment(Integer patientId, String date);

  Appointment findById(Integer id);

  List<Appointment> findAll();

  // TODO: Get apis
}
