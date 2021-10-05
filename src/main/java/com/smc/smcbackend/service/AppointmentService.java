package com.smc.smcbackend.service;

import com.smc.smcbackend.model.Appointment;

public interface AppointmentService {
  Appointment createAppointment(Integer patientId, String date);

  // TODO: Get apis
}
