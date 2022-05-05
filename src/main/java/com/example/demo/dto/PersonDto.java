package com.example.demo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonDto {
	
	
	private String avatar;

	@NotBlank
	private String tele;
	
	@NotBlank
	private String addresseLiv;
	
	@NotBlank
	private String addresseFac;
	
	
	private UserDto userDto;


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


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	
	

}
