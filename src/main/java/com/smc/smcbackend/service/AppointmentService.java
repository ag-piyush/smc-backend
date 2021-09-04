package com.smc.smcbackend.service;

import com.smc.smcbackend.model.Appointment;

public interface AppointmentService {
  Appointment createAppointment(String patientId);
}
