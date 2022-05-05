package com.example.demo.dto;

public class PersonReponse {
	
	
	private String personId;

	private String avatar;

	private String tele;

	private String addresseLiv;

	private String addresseFac;
	
	private UserReponse userReponse;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

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

	public UserReponse getUserReponse() {
		return userReponse;
	}

	public void setUserReponse(UserReponse userReponse) {
		this.userReponse = userReponse;
	}
	
	
	
	

}
