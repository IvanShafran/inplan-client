package com.fivt.inplan.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User extends BaseItem {

	@SerializedName("login")
	@Expose
	private String login;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("passwordHash")
	@Expose
	private Integer passwordHash;

	/**
	* 
	* @return
	* The login
	*/
	public String getLogin() {
	return login;
	}

	/**
	* 
	* @param login
	* The login
	*/
	public void setLogin(String login) {
	this.login = login;
	}

	/**
	* 
	* @return
	* The email
	*/
	public String getEmail() {
	return email;
	}

	/**
	* 
	* @param email
	* The email
	*/
	public void setEmail(String email) {
	this.email = email;
	}

	/**
	* 
	* @return
	* The passwordHash
	*/
	public Integer getPasswordHash() {
	return passwordHash;
	}

	/**
	* 
	* @param passwordHash
	* The passwordHash
	*/
	public void setPasswordHash(Integer passwordHash) {
	this.passwordHash = passwordHash;
	}
	
}
