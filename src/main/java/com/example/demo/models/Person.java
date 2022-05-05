package com.example.demo.models;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4795715088275946582L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String personId;

	@Column(name = "Avatar")
	private String avatar;

	@Column(name = "Tele", nullable = false)
	private String tele;

	@Column(nullable = false)
	private String addresseLiv;

	@Column(nullable = false)
	private String addresseFac;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	public Date createdAt = new Date();

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_at")
	public Date updatedAt = new Date();

	@OneToOne
	@JoinColumn(name = "users_id")
	private UsersEntity user;

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

//    @PrePersist
//    void createdAt() {
//      this.createdAt = this.updatedAt = new Date();
//    }
//
//    @PreUpdate
//    void updatedAt() {
//      this.updatedAt = new Date();
//    }

	// FetchType.LAZY récupérer la person avec liste des factures
	// @OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	// @JoinColumn(name="Code_cli")
	// private List<Facture> factures;

	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getFullName() { return fullName; }
	 * 
	 * public void setFullName(String fullName) { this.fullName = fullName; }
	 * 
	 * public Date getDateOfBirth() { return dateOfBirth; }
	 * 
	 * public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth =
	 * dateOfBirth; }
	 */
}
