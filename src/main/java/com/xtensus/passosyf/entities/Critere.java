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



@Entity
@Table(name="critere")
public class Critere implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer critereId ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeCritereId")
	private TypeCritere typeCritere ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operateurId" )
	private Operateur Operateur ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "natureCritereId")
	private NatureCritere natureCritere ;
	
	private String critereLibelle ;
	private String critereRaccourci ;
	private Boolean critereTypeElimination ;
	private int critereNoteBareme ;
	private int critereValeurLimite ;
	
	
	//constructor
	public Critere(Integer critereId, TypeCritere typeCritere, com.xtensus.passosyf.entities.Operateur operateur,
			NatureCritere natureCritere, String critereLibelle, String critereRaccourci, Boolean critereTypeElimination,
			int critereNoteBareme, int critereValeurLimite) {
		super();
		this.critereId = critereId;
		this.typeCritere = typeCritere;
		Operateur = operateur;
		this.natureCritere = natureCritere;
		this.critereLibelle = critereLibelle;
		this.critereRaccourci = critereRaccourci;
		this.critereTypeElimination = critereTypeElimination;
		this.critereNoteBareme = critereNoteBareme;
		this.critereValeurLimite = critereValeurLimite;
	}

	public Critere() {
		super();
	}

	//getters&setters
	public Integer getCritereId() {
		return critereId;
	}

	public void setCritereId(Integer critereId) {
		this.critereId = critereId;
	}
	
	public TypeCritere getTypeCritere() {
		return typeCritere;
	}

	public void setTypeCritere(TypeCritere typeCritere) {
		this.typeCritere = typeCritere;
	}
	
	public Operateur getOperateur() {
		return Operateur;
	}

	public void setOperateur(Operateur operateur) {
		Operateur = operateur;
	}
	
	public NatureCritere getNatureCritere() {
		return natureCritere;
	}

	public void setNatureCritere(NatureCritere natureCritere) {
		this.natureCritere = natureCritere;
	}
	
	@Column(length = 100)
	public String getCritereLibelle() {
		return critereLibelle;
	}

	public void setCritereLibelle(String critereLibelle) {
		this.critereLibelle = critereLibelle;
	}
	
	@Column(length = 100)
	public String getCritereRaccourci() {
		return critereRaccourci;
	}

	public void setCritereRaccourci(String critereRaccourci) {
		this.critereRaccourci = critereRaccourci;
	}

	public Boolean getCritereTypeElimination() {
		return critereTypeElimination;
	}

	public void setCritereTypeElimination(Boolean critereTypeElimination) {
		this.critereTypeElimination = critereTypeElimination;
	}

	public int getCritereNoteBareme() {
		return critereNoteBareme;
	}

	public void setCritereNoteBareme(int critereNoteBareme) {
		this.critereNoteBareme = critereNoteBareme;
	}

	public int getCritereValeurLimite() {
		return critereValeurLimite;
	}

	public void setCritereValeurLimite(int critereValeurLimite) {
		this.critereValeurLimite = critereValeurLimite;
	}
	
	



}
