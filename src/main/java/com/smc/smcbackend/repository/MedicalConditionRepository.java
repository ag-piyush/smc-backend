package com.smc.smcbackend.repository;

import com.smc.smcbackend.model.MedicalCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalConditionRepository extends JpaRepository<MedicalCondition, Integer> {
}
