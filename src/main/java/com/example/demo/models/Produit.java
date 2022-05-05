package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUIT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
	
	
	@Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
	
	
	@Column(name="Ref_Prod",nullable=false)
	private String ref_prod;
	
	@Column(name="Lib_Prod",nullable=false)
	private String lib_prod;
	
	
	@Column(name="Prix_Prod",nullable=false)
	private Integer prix_prod;
	
	@Column(name="Qty_Prod",nullable=false)
	private double qty_prod;
	
	
//	@ManyToOne()
//	private Facture facture;
	

}
