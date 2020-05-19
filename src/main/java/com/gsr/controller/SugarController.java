package com.gsr.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsr.entity.Message;
import com.gsr.entity.Patient;
import com.gsr.service.SugarService;
import com.gsr.service.SugarSrviceImpl;

@RestController
@RequestMapping("/sugar")
@CrossOrigin(origins = "*")
public class SugarController {

	@Autowired
	private SugarService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAllDetails(){

		ResponseEntity<?> resp=null;
		try {
			List<Patient> list=service.getAllPatients();
			if(list!=null && !list.isEmpty())
				resp=new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<Message> saveSugarDetails(@RequestBody Patient patient) {
		ResponseEntity<Message> resp=null;
		try {
			Long id=service.saveStudent(patient);
			resp=new ResponseEntity<Message>(new Message("SUCCESS",patient.getLevel()),HttpStatus.CREATED);
		}catch(Exception e) {
			resp=new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
}
