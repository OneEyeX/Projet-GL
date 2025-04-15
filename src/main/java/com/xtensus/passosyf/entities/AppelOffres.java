package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="appeloffres")
public class AppelOffres implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="appeloffresId")
	private Integer appelOffreId ;
	
	@Column(name="appelOffreCode", length=100)
	private String appelOffreCode ;
	private String appelOffreIntitule ;
	@Column(length = 1000)
	private String appelOffreObjet ;
	private String appelOffreAvis ;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "natureId")
	private Nature nature ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modeReglementId")
	private ModeReglement modeReglement ;
	
	private Float appelOffrePrixDoc ;
	private int appelOffreNbrLots ;
	private float appelOffreCoutEstime ;
	private Date appelOffreDatePublication ;
	private Date appelOffreDateLimiteRemise ;
	private Date appelOffreDateSeanceOuverturePlis ;
	
	@JsonIgnoreProperties("appelOffres")
	@ManyToMany(mappedBy = "appelOffres")
	private Set<Commission> commissions = new HashSet<Commission>(0);
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatId")
	private Etat etat ;
	
	
	//constructor
	public AppelOffres() {
		super();

	}

	
	public AppelOffres(Integer appelOffreId, String appelOffreCode, String appelOffreIntitule, String appelOffreObjet,
			String appelOffreAvis, Nature nature, ModeReglement modeReglement, Float appelOffrePrixDoc,
			int appelOffreNbrLots, float appelOffreCoutEstime, Date appelOffreDatePublication,
			Date appelOffreDateLimiteRemise, Date appelOffreDateSeanceOuverturePlis, Set<Commission> commissions,
			Etat etat) {
		super();
		this.appelOffreId = appelOffreId;
		this.appelOffreCode = appelOffreCode;
		this.appelOffreIntitule = appelOffreIntitule;
		this.appelOffreObjet = appelOffreObjet;
		this.appelOffreAvis = appelOffreAvis;
		this.nature = nature;
		this.modeReglement = modeReglement;
		this.appelOffrePrixDoc = appelOffrePrixDoc;
		this.appelOffreNbrLots = appelOffreNbrLots;
		this.appelOffreCoutEstime = appelOffreCoutEstime;
		this.appelOffreDatePublication = appelOffreDatePublication;
		this.appelOffreDateLimiteRemise = appelOffreDateLimiteRemise;
		this.appelOffreDateSeanceOuverturePlis = appelOffreDateSeanceOuverturePlis;
		this.commissions = commissions;
		this.etat = etat;
	}


	//getters&setters
	public Integer getAppelOffreId() {
		return appelOffreId;
	}

	public void setAppelOffreId(Integer appelOffreId) {
		this.appelOffreId = appelOffreId;
	}

	public String getAppelOffreIntitule() {
		return appelOffreIntitule;
	}

	public void setAppelOffreIntitule(String appelOffreIntitule) {
		this.appelOffreIntitule = appelOffreIntitule;
	}

	public String getAppelOffreObjet() {
		return appelOffreObjet;
	}

	public void setAppelOffreObjet(String appelOffreObjet) {
		this.appelOffreObjet = appelOffreObjet;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public ModeReglement getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(ModeReglement modeReglement) {
		this.modeReglement = modeReglement;
	}

	public Float getAppelOffrePrixDoc() {
		return appelOffrePrixDoc;
	}

	public void setAppelOffrePrixDoc(Float appelOffrePrixDoc) {
		this.appelOffrePrixDoc = appelOffrePrixDoc;
	}

	public int getAppelOffreNbrLots() {
		return appelOffreNbrLots;
	}

	public void setAppelOffreNbrLots(int appelOffreNbrLots) {
		this.appelOffreNbrLots = appelOffreNbrLots;
	}

	public float getAppelOffreCoutEstime() {
		return appelOffreCoutEstime;
	}

	public void setAppelOffreCoutEstime(float appelOffreCoutEstime) {
		this.appelOffreCoutEstime = appelOffreCoutEstime;
	}

	public Date getAppelOffreDatePublication() {
		return appelOffreDatePublication;
	}

	public void setAppelOffreDatePublication(Date appelOffreDatePublication) {
		this.appelOffreDatePublication = appelOffreDatePublication;
	}

	public Date getAppelOffreDateLimiteRemise() {
		return appelOffreDateLimiteRemise;
	}

	public void setAppelOffreDateLimiteRemise(Date appelOffreDateLimiteRemise) {
		this.appelOffreDateLimiteRemise = appelOffreDateLimiteRemise;
	}

	public Date getAppelOffreDateSeanceOuverturePlis() {
		return appelOffreDateSeanceOuverturePlis;
	}

	public void setAppelOffreDateSeanceOuverturePlis(Date appelOffreDateSeanceOuverturePlis) {
		this.appelOffreDateSeanceOuverturePlis = appelOffreDateSeanceOuverturePlis;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Set<Commission> getCommissions() {
		return commissions;
	}

	public void setCommissions(Set<Commission> commissions) {
		this.commissions = commissions;
	}

	public String getAppelOffreCode() {
		return appelOffreCode;
	}

	public void setAppelOffreCode(String appelOffreCode) {
		this.appelOffreCode = appelOffreCode;
	}

	public String getAppelOffreAvis() {
		return appelOffreAvis;
	}

	public void setAppelOffreAvis(String appelOffreAvis) {
		this.appelOffreAvis = appelOffreAvis;
	}

	
	

	
}
