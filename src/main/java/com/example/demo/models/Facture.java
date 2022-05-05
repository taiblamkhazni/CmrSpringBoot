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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "facture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8256447327929109847L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable=false)
	private String factureId;
	
	@Column(name = "Ref_fact", nullable = false)
    private String refFact;
	
	
	@Temporal(TemporalType.DATE)
    @Column(name = "Date_fact")
    public Date datefact;
	
	@ManyToOne
	@JoinColumn(name="users_id")
	private UsersEntity user;


	public String getFactureId() {
		return factureId;
	}

	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}
	
	
	 
//	 @OneToMany(mappedBy="facture",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	 private List<Produit> produit;

}
