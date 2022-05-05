package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FactureReponse {
	
	private String factureId;
	
	private String refFact;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	public Date datefact;
	
	

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

	
	
	

}
