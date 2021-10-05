package com.smc.smcbackend.repository;

import com.smc.smcbackend.model.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalTestRepository extends JpaRepository<MedicalTest, Integer> {
}
