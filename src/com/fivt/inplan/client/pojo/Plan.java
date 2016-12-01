package com.fivt.inplan.client.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan extends BaseItem {
	@SerializedName("courses")
	@Expose
	private List<Long> courses = new ArrayList<Long>();
	@SerializedName("specialization")
	@Expose
	private Long specialization;

	/**
	* 
	* @return
	* The courses
	*/
	public List<Long> getCourses() {
	return courses;
	}

	/**
	* 
	* @param courses
	* The courses
	*/
	public void setCourses(List<Long> courses) {
	this.courses = courses;
	}

	/**
	* 
	* @return
	* The specialization
	*/
	public Long getSpecialization() {
	return specialization;
	}

	/**
	* 
	* @param specialization
	* The specialization
	*/
	public void setSpecialization(Long specialization) {
	this.specialization = specialization;
	}
}
