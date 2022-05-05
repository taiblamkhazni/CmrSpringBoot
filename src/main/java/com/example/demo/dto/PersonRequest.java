package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

public class PersonRequest {
	
	
	
	private String avatar;

	
	private String tele;
	
	
	private String addresseLiv;
	
	
	private String addresseFac;
	
	
	private UserRequest userRequest;


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getAddresseLiv() {
		return addresseLiv;
	}


	public void setAddresseLiv(String addresseLiv) {
		this.addresseLiv = addresseLiv;
	}


	public String getAddresseFac() {
		return addresseFac;
	}


	public void setAddresseFac(String addresseFac) {
		this.addresseFac = addresseFac;
	}


	public UserRequest getUserRequest() {
		return userRequest;
	}


	public void setUserRequest(UserRequest userRequest) {
		this.userRequest = userRequest;
	}
	
	

}
