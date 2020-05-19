package com.gsr.service;

import java.util.List;

import com.gsr.entity.Patient;

public interface SugarService {

	public Long saveStudent(Patient s);
	public List<Patient> getAllPatients();
}
