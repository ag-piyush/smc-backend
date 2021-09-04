package com.smc.smcbackend.controller;

import com.smc.smcbackend.model.Patient;
import com.smc.smcbackend.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") String id){
        return this.patientService.findById(id);
    }

    @GetMapping
    public List<Patient> findAllPatients(){
        return this.patientService.findAll();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient){
        return this.patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") String id){
        this.patientService.deletePatient(id);
    }
}
