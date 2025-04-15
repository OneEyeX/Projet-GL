package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typecahierdescharges")
public class TypeCahierDesCharges implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer typeCahierDesChargesId ;
	
	private String typeCahierDesChargesDescription ;
	private String typeCahierDesChargesCode ;
	
	
	//constructor
	public TypeCahierDesCharges(Integer typeCahierDesChargesId, String typeCahierDesChargesDescription,
			String typeCahierDesChargesCode) {
		super();
		this.typeCahierDesChargesId = typeCahierDesChargesId;
		this.typeCahierDesChargesDescription = typeCahierDesChargesDescription;
		this.typeCahierDesChargesCode = typeCahierDesChargesCode;
	}


	public TypeCahierDesCharges() {
		super();
	}

	//getters&setters
	public Integer getTypeCahierDesChargesId() {
		return typeCahierDesChargesId;
	}

	public void setTypeCahierDesChargesId(Integer typeCahierDesChargesId) {
		this.typeCahierDesChargesId = typeCahierDesChargesId;
	}

	@Column(name = "typeCahierDesChargesDescription", length = 1000)
	public String getTypeCahierDesChargesDescription() {
		return typeCahierDesChargesDescription;
	}

	public void setTypeCahierDesChargesDescription(String typeCahierDesChargesDescription) {
		this.typeCahierDesChargesDescription = typeCahierDesChargesDescription;
	}

	public String getTypeCahierDesChargesCode() {
		return typeCahierDesChargesCode;
	}

	public void setTypeCahierDesChargesCode(String typeCahierDesChargesCode) {
		this.typeCahierDesChargesCode = typeCahierDesChargesCode;
	}
	
	


}
