package com.gsr.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = " Pre Sugar Level is required")
	// @Column(name="/pre")
	private String sugar_Level;

	//@Column(name="/post")
	private String postSugar_Level;

	@NotNull(message = "Test Date is required")
	private LocalDate testDate;

	private String level;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSugar_Level() {
		return sugar_Level;
	}

	public void setSugar_Level(String sugar_Level) {
		this.sugar_Level = sugar_Level;
	}

	public String getPostSugar_Level() {
		return postSugar_Level;
	}

	public void setPostSugar_Level(String postSugar_Level) {
		this.postSugar_Level = postSugar_Level;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", sugar_Level=" + sugar_Level + ", postSugar_Level=" + postSugar_Level
				+ ", testDate=" + testDate + ", level=" + level + "]";
	}

	

}
