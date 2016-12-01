package com.fivt.inplan.client.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Course extends BaseItem {

	@SerializedName("label")
	@Expose
	private String label;
	@SerializedName("creditsPrice")
	@Expose
	private Long creditsPrice;
	@SerializedName("studyArea")
	@Expose
	private String studyArea;
	@SerializedName("requiredCompletedCourses")
	@Expose
	private List<Long> requiredCompletedCourses = new ArrayList<Long>();
	@SerializedName("professors")
	@Expose
	private List<Long> professors = new ArrayList<Long>();
	
	/**
	* 
	* @return
	* The label
	*/
	public String getLabel() {
	return label;
	}
	
	/**
	* 
	* @param label
	* The label
	*/
	public void setLabel(String label) {
	this.label = label;
	}
	
	/**
	* 
	* @return
	* The creditsPrice
	*/
	public Long getCreditsPrice() {
	return creditsPrice;
	}
	
	/**
	* 
	* @param creditsPrice
	* The creditsPrice
	*/
	public void setCreditsPrice(Long creditsPrice) {
	this.creditsPrice = creditsPrice;
	}
	
	/**
	* 
	* @return
	* The studyArea
	*/
	public String getStudyArea() {
	return studyArea;
	}
	
	/**
	* 
	* @param studyArea
	* The studyArea
	*/
	public void setStudyArea(String studyArea) {
	this.studyArea = studyArea;
	}
	
	/**
	* 
	* @return
	* The requiredCompletedCourses
	*/
	public List<Long> getRequiredCompletedCourses() {
	return requiredCompletedCourses;
	}
	
	/**
	* 
	* @param requiredCompletedCourses
	* The requiredCompletedCourses
	*/
	public void setRequiredCompletedCourses(List<Long> requiredCompletedCourses) {
	this.requiredCompletedCourses = requiredCompletedCourses;
	}
	
	/**
	* 
	* @return
	* The professors
	*/
	public List<Long> getProfessors() {
	return professors;
	}
	
	/**
	* 
	* @param professors
	* The professors
	*/
	public void setProfessors(List<Long> professors) {
	this.professors = professors;
	}

}
