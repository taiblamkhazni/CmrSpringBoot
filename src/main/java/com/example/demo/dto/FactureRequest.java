package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.models.UsersEntity;

public class FactureRequest {

	@NotBlank
	private String refFact;
	
	@NotNull
	public Date datefact;
	
	@NotNull
	public UsersEntity usersEntity;



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

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}
	
	
	
}
