package com.fivt.inplan.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseItem {
	@SerializedName("id")
	@Expose
	private Long id;

	/**
	* 
	* @return
	* The id
	*/
	public Long getId() {
	return id;
	}

	/**
	* 
	* @param id
	* The id
	*/
	public void setId(Long id) {
	this.id = id;
	}
}
