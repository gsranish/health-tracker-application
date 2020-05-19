package com.gsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsr.entity.Patient;

public interface SugarRepository extends JpaRepository<Patient, Long>{

}
