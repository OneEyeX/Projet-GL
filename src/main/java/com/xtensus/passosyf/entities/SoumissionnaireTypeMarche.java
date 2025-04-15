package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "soumissionnairetypemarche")
public class SoumissionnaireTypeMarche implements Serializable {

	private static final long serialVersionUID = -6752916763733886636L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "soumissionnaireTypeMarcheId", unique = true, nullable = false)
	private int soumissionnaireTypeMarcheId;
	
	//private Soumissionnaire soumissionnaireId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeMarcheId", nullable = false)
	private TypeMarche typeMarche;


	//constructor
	public SoumissionnaireTypeMarche(int soumissionnaireTypeMarcheId, TypeMarche typeMarche) {
		super();
		this.soumissionnaireTypeMarcheId = soumissionnaireTypeMarcheId;
		this.typeMarche = typeMarche;
	}
	
	public SoumissionnaireTypeMarche() {
		super();
	}
	
	
	
	//getters&setters
	public int getSoumissionnaireTypeMarcheId() {
		return soumissionnaireTypeMarcheId;
	}

	public void setSoumissionnaireTypeMarcheId(int soumissionnaireTypeMarcheId) {
		this.soumissionnaireTypeMarcheId = soumissionnaireTypeMarcheId;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "soumissionnaireId", nullable = false)
//	@JsonIgnore
//	public Soumissionnaire getSoumissionnaireId() {
//		return soumissionnaireId;
//	}
//
//	public void setSoumissionnaireId(Soumissionnaire soumissionnaireId) {
//		this.soumissionnaireId = soumissionnaireId;
//	}

	public TypeMarche getTypeMarche() {
		return typeMarche;
	}

	public void setTypeMarche(TypeMarche typeMarcheId) {
		this.typeMarche = typeMarcheId;
	}
	
}
