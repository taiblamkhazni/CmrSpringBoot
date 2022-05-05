package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.models.UsersEntity;

public class FactureDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5002146325999494449L;

	private long id;
	private String factureId;

	private String refFact;

	public Date datefact;

	private UserDto user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFactureId() {
		return factureId;
	}

	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}





	public String getRefFact() {
		return refFact;
	}

	public void setRefFact(String refFact) {
		this.refFact = refFact;
	}

	public Date getDatefact() {
		return datefact;
	}

	public void setDatefact(Date datefact) {
		this.datefact = datefact;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto userDto) {
		this.user = userDto;
	}
	
	

}
