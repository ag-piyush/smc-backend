package com.smc.smcbackend.controller;

import com.smc.smcbackend.model.Appointment;
import com.smc.smcbackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<Appointment> createAppointment(@PathVariable("patientId") String patientId){
        Appointment appointment = this.appointmentService.createAppointment(patientId);

        if(appointment == null)
            return ResponseEntity.status(401).build();

        return ResponseEntity.ok(appointment);
    }
}