package com.fivt.inplan.client.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specialization extends BaseItem {
	@SerializedName("label")
	@Expose
	private String label;
	@SerializedName("minExtraCoursesCount")
	@Expose
	private Long minExtraCoursesCount;
	@SerializedName("requiredCourses")
	@Expose
	private List<Long> requiredCourses = new ArrayList<Long>();

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
	* The minExtraCoursesCount
	*/
	public Long getMinExtraCoursesCount() {
	return minExtraCoursesCount;
	}

	/**
	* 
	* @param minExtraCoursesCount
	* The minExtraCoursesCount
	*/
	public void setMinExtraCoursesCount(Long minExtraCoursesCount) {
	this.minExtraCoursesCount = minExtraCoursesCount;
	}

	/**
	* 
	* @return
	* The requiredCourses
	*/
	public List<Long> getRequiredCourses() {
	return requiredCourses;
	}

	/**
	* 
	* @param requiredCourses
	* The requiredCourses
	*/
	public void setRequiredCourses(List<Long> requiredCourses) {
	this.requiredCourses = requiredCourses;
	}
}
