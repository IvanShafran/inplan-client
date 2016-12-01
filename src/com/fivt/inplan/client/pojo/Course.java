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
	private Integer creditsPrice;
	@SerializedName("studyArea")
	@Expose
	private String studyArea;
	@SerializedName("requiredCompletedCourses")
	@Expose
	private List<Object> requiredCompletedCourses = new ArrayList<Object>();
	@SerializedName("professors")
	@Expose
	private List<Integer> professors = new ArrayList<Integer>();
	
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
	public Integer getCreditsPrice() {
	return creditsPrice;
	}
	
	/**
	* 
	* @param creditsPrice
	* The creditsPrice
	*/
	public void setCreditsPrice(Integer creditsPrice) {
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
	public List<Object> getRequiredCompletedCourses() {
	return requiredCompletedCourses;
	}
	
	/**
	* 
	* @param requiredCompletedCourses
	* The requiredCompletedCourses
	*/
	public void setRequiredCompletedCourses(List<Object> requiredCompletedCourses) {
	this.requiredCompletedCourses = requiredCompletedCourses;
	}
	
	/**
	* 
	* @return
	* The professors
	*/
	public List<Integer> getProfessors() {
	return professors;
	}
	
	/**
	* 
	* @param professors
	* The professors
	*/
	public void setProfessors(List<Integer> professors) {
	this.professors = professors;
	}

}
