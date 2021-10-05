package com.smc.smcbackend.controller;

import com.smc.smcbackend.model.Appointment;
import com.smc.smcbackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
  private final AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/create")
  public ResponseEntity<Appointment> createAppointment(
      @RequestParam(value = "patientId") Integer patientId,
      @RequestParam(value = "date") String date) {
    Appointment appointment = this.appointmentService.createAppointment(patientId, date);

    if (appointment == null) return ResponseEntity.status(401).build();

    return ResponseEntity.ok(appointment);
  }

  @GetMapping
  public List<Appointment> findAllAppointments(){
    return this.appointmentService.findAll();
  }

  @GetMapping("/{id}")
  public Appointment findById(@PathVariable("id") Integer id){
    return this.appointmentService.findById(id);
  }
}
