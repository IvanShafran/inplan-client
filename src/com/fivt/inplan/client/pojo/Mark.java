package com.fivt.inplan.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mark extends BaseItem {
	@SerializedName("value")
	@Expose
	private Integer value;
	@SerializedName("student")
	@Expose
	private Long student;
	@SerializedName("professor")
	@Expose
	private Long professor;
	@SerializedName("course")
	@Expose
	private Long course;
	@SerializedName("description")
	@Expose
	private String description;

	/**
	* 
	* @return
	* The value
	*/
	public Integer getValue() {
	return value;
	}

	/**
	* 
	* @param value
	* The value
	*/
	public void setValue(Integer value) {
	this.value = value;
	}

	/**
	* 
	* @return
	* The student
	*/
	public Long getStudent() {
	return student;
	}

	/**
	* 
	* @param student
	* The student
	*/
	public void setStudent(Long student) {
	this.student = student;
	}

	/**
	* 
	* @return
	* The professor
	*/
	public Long getProfessor() {
	return professor;
	}

	/**
	* 
	* @param professor
	* The professor
	*/
	public void setProfessor(Long professor) {
	this.professor = professor;
	}

	/**
	* 
	* @return
	* The course
	*/
	public Long getCourse() {
	return course;
	}

	/**
	* 
	* @param course
	* The course
	*/
	public void setCourse(Long course) {
	this.course = course;
	}

	/**
	* 
	* @return
	* The description
	*/
	public String getDescription() {
	return description;
	}

	/**
	* 
	* @param description
	* The description
	*/
	public void setDescription(String description) {
	this.description = description;
	}
}
