package com.xtensus.passosyf.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pays")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Pays  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paysId;
	@Column(name = "paysCode", length = 254)
	private String paysCode;
	@Column(name = "paysLibelle", length = 254)
	private String paysLibelle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deviseId") 
	private Devise devise;


	//constructor
	public Pays(String paysCode, String paysLibelle) {
		this.paysCode = paysCode;
		this.paysLibelle = paysLibelle;
	}

	
	public Pays() {
		super();
	}


	//getters&setters
	public Integer getPaysId() {
		return this.paysId;
	}

	public void setPaysId(Integer paysId) {
		this.paysId = paysId;
	}

	public String getPaysCode() {
		return this.paysCode;
	}

	public void setPaysCode(String paysCode) {
		this.paysCode = paysCode;
	}

	public String getPaysLibelle() {
		return this.paysLibelle;
	}

	public void setPaysLibelle(String paysLibelle) {
		this.paysLibelle = paysLibelle;
	}
	


	


}
