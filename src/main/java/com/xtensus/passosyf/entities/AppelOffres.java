package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "appeloffres")
public class AppelOffres implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "appeloffresId")
    private Integer appelOffreId;

    @Column(name = "appelOffreCode", length = 100)
    private String appelOffreCode;

    private String appelOffreIntitule;

    @Column(length = 1000)
    private String appelOffreObjet;

    private String appelOffreAvis;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "natureId")
    private Nature nature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modeReglementId")
    private ModeReglement modeReglement;

    private Float appelOffrePrixDoc;
    private int appelOffreNbrLots;
    private float appelOffreCoutEstime;
    private Date appelOffreDatePublication;
    private Date appelOffreDateLimiteRemise;
    private Date appelOffreDateSeanceOuverturePlis;

    @JsonIgnoreProperties("appelOffres")
    @ManyToMany(mappedBy = "appelOffres")
    private Set<Commission> commissions = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "etatId")
    private Etat etat;

    // ========== Constructeurs ==========
    public AppelOffres() {
        super();
    }

    public AppelOffres(Integer appelOffreId, String appelOffreCode, String appelOffreIntitule, String appelOffreObjet,
                       String appelOffreAvis, Nature nature, ModeReglement modeReglement, Float appelOffrePrixDoc,
                       int appelOffreNbrLots, float appelOffreCoutEstime, Date appelOffreDatePublication,
                       Date appelOffreDateLimiteRemise, Date appelOffreDateSeanceOuverturePlis, Set<Commission> commissions,
                       Etat etat) {
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
 
 // ===========================================================
 // ================== VALIDATION DES CONTRAINTES OCL =========
 // ===========================================================
 // Cette classe applique des contraintes métiers (OCL) sur 
 // l'entité AppelOffres avant sa persistance ou sa mise à jour
 // ===========================================================

 /**
  * Contrainte OCL n°1 :
  * Le coût estimé d'un appel d'offres doit être strictement supérieur à 0.
  */
 private void validateCoutEstime() {
     if (appelOffreCoutEstime <= 0) {
         throw new IllegalArgumentException("Le coût estimé doit être strictement positif.");
     }
 }

 /**
  * Contrainte OCL n°2 :
  * Le nombre de lots d'un appel d'offres doit être strictement supérieur à 0.
  */
 private void validateNombreLots() {
     if (appelOffreNbrLots <= 0) {
         throw new IllegalArgumentException("Le nombre de lots doit être strictement positif.");
     }
 }

 /**
  * Contrainte OCL n°3 :
  * Chaque commission associée à un appel d’offres doit avoir une référence unique.
  */
 private void validateCommissionsUniques() {
     Set<Integer> references = new HashSet<>();
     for (Commission c : commissions) {
         if (c.getCommissionReference() != null && !references.add(c.getCommissionReference())) {
             throw new IllegalStateException("Doublon détecté dans la liste des commissions.");
         }
     }
 }

 /**
  * Méthode de validation globale appelée automatiquement :
  * - Avant la création de l'entité en base (@PrePersist)
  * - Avant toute mise à jour de l'entité en base (@PreUpdate)
  * 
  * Elle regroupe les contraintes OCL à respecter.
  */
 @PrePersist
 @PreUpdate
 private void validateOCLConstraints() { 
     validateCoutEstime();
     validateNombreLots();
     validateCommissionsUniques();
 }

    // ========== Getters & Setters ==========
    public Integer getAppelOffreId() {
        return appelOffreId;
    }

    public void setAppelOffreId(Integer appelOffreId) {
        this.appelOffreId = appelOffreId;
    }

    public String getAppelOffreCode() {
        return appelOffreCode;
    }

    public void setAppelOffreCode(String appelOffreCode) {
        this.appelOffreCode = appelOffreCode;
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

    public String getAppelOffreAvis() {
        return appelOffreAvis;
    }

    public void setAppelOffreAvis(String appelOffreAvis) {
        this.appelOffreAvis = appelOffreAvis;
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

    public Set<Commission> getCommissions() {
        return commissions;
    }

    public void setCommissions(Set<Commission> commissions) {
        this.commissions = commissions;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
