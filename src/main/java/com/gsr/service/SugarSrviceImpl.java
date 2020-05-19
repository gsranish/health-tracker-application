package com.gsr.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsr.entity.Patient;
import com.gsr.repository.SugarRepository;

@Service
public class SugarSrviceImpl implements SugarService{
	
	private static final Logger LOGGER = LogManager.getLogger(SugarSrviceImpl.class.getName());

	
	@Autowired
	private SugarRepository repo;

	@Override
	public Long saveStudent(Patient s) {
		LOGGER.info("*****  saveStudent Method from service Layer ****** ");
		int preLevel=Integer.valueOf(s.getSugar_Level());
		int postLevel=Integer.valueOf(s.getPostSugar_Level());
		int diff=postLevel-preLevel;
		String msg=null;
		if(diff<=60) {
			msg="Sugar Level is low";
		}else if(diff>60 && diff <=180) {
			msg="Sugar Level is normal";
		}else {
			msg="Sugar Level is high";
		}
		s.setLevel(msg);
		return repo.save(s).getId();
	}

	@Override
	public List<Patient> getAllPatients() {
		LOGGER.info("****** getAllPatients Method from Service layer ****** ");
		return repo.findAll();
		
	}

}
