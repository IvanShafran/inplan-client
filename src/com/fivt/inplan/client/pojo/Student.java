package com.fivt.inplan.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student extends User {
	@SerializedName("firstname")
	@Expose
	private String firstname;
	@SerializedName("middlename")
	@Expose
	private String middlename;
	@SerializedName("lastname")
	@Expose
	private String lastname;
	@SerializedName("sex")
	@Expose
	private String sex;
	@SerializedName("plan")
	@Expose
	private Long plan;

	/**
	* 
	* @return
	* The firstname
	*/
	public String getFirstname() {
	return firstname;
	}

	/**
	* 
	* @param firstname
	* The firstname
	*/
	public void setFirstname(String firstname) {
	this.firstname = firstname;
	}

	/**
	* 
	* @return
	* The middlename
	*/
	public String getMiddlename() {
	return middlename;
	}

	/**
	* 
	* @param middlename
	* The middlename
	*/
	public void setMiddlename(String middlename) {
	this.middlename = middlename;
	}

	/**
	* 
	* @return
	* The lastname
	*/
	public String getLastname() {
	return lastname;
	}

	/**
	* 
	* @param lastname
	* The lastname
	*/
	public void setLastname(String lastname) {
	this.lastname = lastname;
	}

	/**
	* 
	* @return
	* The sex
	*/
	public String getSex() {
	return sex;
	}

	/**
	* 
	* @param sex
	* The sex
	*/
	public void setSex(String sex) {
	this.sex = sex;
	}

	/**
	* 
	* @return
	* The plan
	*/
	public Long getPlan() {
	return plan;
	}

	/**
	* 
	* @param plan
	* The plan
	*/
	public void setPlan(Long plan) {
	this.plan = plan;
	}

}
