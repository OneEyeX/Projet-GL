package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "soumissionnaire")
public class Soumissionnaire implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "soumissionnaireReference", unique = true)
	private Integer soumissionnaireReference;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fonctionId")
	private Fonction fonction;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formeJuridiqueId")
	private Formejuridique formejuridique;
	
	@Column(name = "soumissionnaireRaisonSociale", length = 254)
	private String soumissionnaireRaisonSociale; //
	@Column(name = "soumissionnaireCapital", precision = 12, scale = 0)
	private Float soumissionnaireCapital;
	@Column(name = "soumissionnaireMatriculeFiscale", length = 254)
	private String soumissionnaireMatriculeFiscal; //
	@Column(name = "soumissionnaireAdresseSiegeSocial", length = 254)
	private String soumissionnaireAdresseSiegeSocial;
	@Column(name = "soumissionnaireAffiliationCNSS", length = 254)
	private String soumissionnaireAffiliationCnss;
	@Column(name = "soumissionnaireNumeroRIB", length = 254)
	private String soumissionnaireNumeroRib;
	@Column(name = "soumissionnaireLieuOuvertureCompte", length = 254)
	private String soumissionnaireLieuOuvertureCompte;
	
	@Column(name = "soumissionnaireAnneeCreation", length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date soumissionnaireAnneeCreation;
	@Column(name = "soumissionnaireIdentifiant", length = 254)
	private String soumissionnaireIdentifiant;
	@Column(name = "soumissionnaireNom", length = 254)
	private String soumissionnaireNom;
	@Column(name = "soumissionnairePrenom", length = 254)
	private String soumissionnairePrenom;
	
	@Column(name = "soumissionnaireTelEntreprise", length = 10)
	private String soumissionnaireTel;
	
	@Column(name = "soumissionnaireFax", length = 10)
	private String soumissionnaireFax;
	@Column(name = "soumissionnaireMailEntreprise", length = 250)
	private String soumissionnaireMailEntreprise;
	@Column(name = "soumissionnaireSiteWeb", length = 250)
	private String soumissionnaireSiteWeb;
	@Column(name = "soumissionnaireTitre", length = 250)
	private String soumissionnaireTitreRep;
	@Column(name = "soumissionnaireMailRep", length = 250)
	private String soumissionnaireMailRep;
	@Column(name = "soumissionnaireTel", length = 10)
	private String soumissionnaireTelRep;
	
	@OneToMany( cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "soumissionnaireId")
	private Set<SoumissionnaireTypeMarche> soumissionnaireTypeMarche=new HashSet<SoumissionnaireTypeMarche>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soumissionnaireGouvernorat")
	private Gouvernerat gouvernorat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soumissionnaireVille")
	private Ville ville;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soumissionnairePays")
	private Pays pays; //
	
	@Column(name = "soumissionnaireNumeroRegistreCommerce", length = 45)
	private String soumissionnaireNumeroRegistreCommerce; //
	@Column(name = "soumissionnaireCodePostalId", length = 45)
	private Integer codePostaleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatId") 
	private Etat etat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "soumissionnaireEtatCompte")
	private Etat soumissionnaireEtatCompte;
	
	@Column(name = "soumissionnaireAutreAdresse")
	private String soumissionnaireAutreAdresse;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "soumissionnaireRepresentantLegalTitre")
	private RepresentantLegalTitre soumissionnaireRepresentantLegalTitre;
	
	@Column(name = "soumissionnaireBoitePosteId")
	private Integer soumissionnaireBoitePosteId;
	@Column(name = "soumissionnaireGenre")
	private Integer soumissionnaireGenre;
	
	
	private Boolean soumissionnaireAvecInscription;

//		private Set<Soumission> soumissions = new HashSet<Soumission>(0);


	
	//constructor
	public Soumissionnaire(Formejuridique formejuridique) {
		this.formejuridique = formejuridique;
	}
	
	public Soumissionnaire(Fonction fonction, Formejuridique formejuridique, String soumissionnaireRaisonSociale,
			Float soumissionnaireCapital, String soumissionnaireMatriculeFiscal,
			String soumissionnaireAdresseSiegeSocial, String soumissionnaireAffiliationCnss,
			String soumissionnaireNumeroRib, String soumissionnaireLieuOuvertureCompte,
			Date soumissionnaireAnneeCreation, String soumissionnaireIdentifiant, String soumissionnaireNom,
			String soumissionnairePrenom) {
		this.fonction = fonction;
		this.formejuridique = formejuridique;
		this.soumissionnaireRaisonSociale = soumissionnaireRaisonSociale;
		this.soumissionnaireCapital = soumissionnaireCapital;
		this.soumissionnaireMatriculeFiscal = soumissionnaireMatriculeFiscal;
		this.soumissionnaireAdresseSiegeSocial = soumissionnaireAdresseSiegeSocial;
		this.soumissionnaireAffiliationCnss = soumissionnaireAffiliationCnss;
		this.soumissionnaireNumeroRib = soumissionnaireNumeroRib;
		this.soumissionnaireLieuOuvertureCompte = soumissionnaireLieuOuvertureCompte;
		this.soumissionnaireAnneeCreation = soumissionnaireAnneeCreation;
		this.soumissionnaireIdentifiant = soumissionnaireIdentifiant;
		this.soumissionnaireNom = soumissionnaireNom;
		this.soumissionnairePrenom = soumissionnairePrenom;
//			this.soumissions = soumissions;
	}
	
	public Soumissionnaire() {
		
	}

	//getters&setters
	public Integer getSoumissionnaireReference() {
		return this.soumissionnaireReference;
	}

	public void setSoumissionnaireReference(Integer soumissionnaireReference) {
		this.soumissionnaireReference = soumissionnaireReference;
	}

	public Fonction getFonction() {
		return this.fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Formejuridique getFormejuridique() {
		return this.formejuridique;
	}

	public void setFormejuridique(Formejuridique formejuridique) {
		this.formejuridique = formejuridique;
	}

	public String getSoumissionnaireRaisonSociale() {
		return this.soumissionnaireRaisonSociale;
	}

	public void setSoumissionnaireRaisonSociale(String soumissionnaireRaisonSociale) {
		this.soumissionnaireRaisonSociale = soumissionnaireRaisonSociale;
	}

	public Float getSoumissionnaireCapital() {
		return this.soumissionnaireCapital;
	}

	public void setSoumissionnaireCapital(Float soumissionnaireCapital) {
		this.soumissionnaireCapital = soumissionnaireCapital;
	}

	public String getSoumissionnaireMatriculeFiscal() {
		return this.soumissionnaireMatriculeFiscal;
	}

	public void setSoumissionnaireMatriculeFiscal(String soumissionnaireMatriculeFiscal) {
		this.soumissionnaireMatriculeFiscal = soumissionnaireMatriculeFiscal;
	}

	public String getSoumissionnaireAdresseSiegeSocial() {
		return this.soumissionnaireAdresseSiegeSocial;
	}

	public void setSoumissionnaireAdresseSiegeSocial(String soumissionnaireAdresseSiegeSocial) {
		this.soumissionnaireAdresseSiegeSocial = soumissionnaireAdresseSiegeSocial;
	}

	public String getSoumissionnaireAffiliationCnss() {
		return this.soumissionnaireAffiliationCnss;
	}

	public void setSoumissionnaireAffiliationCnss(String soumissionnaireAffiliationCnss) {
		this.soumissionnaireAffiliationCnss = soumissionnaireAffiliationCnss;
	}

	public String getSoumissionnaireNumeroRib() {
		return this.soumissionnaireNumeroRib;
	}

	public void setSoumissionnaireNumeroRib(String soumissionnaireNumeroRib) {
		this.soumissionnaireNumeroRib = soumissionnaireNumeroRib;
	}

	public String getSoumissionnaireLieuOuvertureCompte() {
		return this.soumissionnaireLieuOuvertureCompte;
	}

	public void setSoumissionnaireLieuOuvertureCompte(String soumissionnaireLieuOuvertureCompte) {
		this.soumissionnaireLieuOuvertureCompte = soumissionnaireLieuOuvertureCompte;
	}

	public Date getSoumissionnaireAnneeCreation() {
		return this.soumissionnaireAnneeCreation;
	}

	public void setSoumissionnaireAnneeCreation(Date soumissionnaireAnneeCreation) {
		this.soumissionnaireAnneeCreation = soumissionnaireAnneeCreation;
	}

	public String getSoumissionnaireIdentifiant() {
		return this.soumissionnaireIdentifiant;
	}

	public void setSoumissionnaireIdentifiant(String soumissionnaireIdentifiant) {
		this.soumissionnaireIdentifiant = soumissionnaireIdentifiant;
	}

	public String getSoumissionnaireNom() {
		return this.soumissionnaireNom;
	}

	public void setSoumissionnaireNom(String soumissionnaireNom) {
		this.soumissionnaireNom = soumissionnaireNom;
	}

	public String getSoumissionnairePrenom() {
		return this.soumissionnairePrenom;
	}

	public void setSoumissionnairePrenom(String soumissionnairePrenom) {
		this.soumissionnairePrenom = soumissionnairePrenom;
	}

//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "soumissionnaire")
//		public Set<Soumission> getSoumissions() {
//			return this.soumissions;
//		}
	//
//		public void setSoumissions(Set<Soumission> soumissions) {
//			this.soumissions = soumissions;
//		}

	public String getSoumissionnaireTel() {
		return soumissionnaireTel;
	}

	public void setSoumissionnaireTel(String soumissionnaireTel) {
		this.soumissionnaireTel = soumissionnaireTel;
	}

	public String getSoumissionnaireFax() {
		return soumissionnaireFax;
	}

	public void setSoumissionnaireFax(String soumissionnaireFax) {
		this.soumissionnaireFax = soumissionnaireFax;
	}

	public String getSoumissionnaireMailEntreprise() {
		return soumissionnaireMailEntreprise;
	}

	public void setSoumissionnaireMailEntreprise(String soumissionnaireMailEntreprise) {
		this.soumissionnaireMailEntreprise = soumissionnaireMailEntreprise;
	}

	public String getSoumissionnaireSiteWeb() {
		return soumissionnaireSiteWeb;
	}

	public void setSoumissionnaireSiteWeb(String soumissionnaireSiteWeb) {
		this.soumissionnaireSiteWeb = soumissionnaireSiteWeb;
	}

	public String getSoumissionnaireTitreRep() {
		return soumissionnaireTitreRep;
	}

	public void setSoumissionnaireTitreRep(String soumissionnaireTitreRep) {
		this.soumissionnaireTitreRep = soumissionnaireTitreRep;
	}

	public String getSoumissionnaireMailRep() {
		return soumissionnaireMailRep;
	}

	public void setSoumissionnaireMailRep(String soumissionnaireMailRep) {
		this.soumissionnaireMailRep = soumissionnaireMailRep;
	}

	public String getSoumissionnaireTelRep() {
		return soumissionnaireTelRep;
	}

	public void setSoumissionnaireTelRep(String soumissionnaireTelRep) {
		this.soumissionnaireTelRep = soumissionnaireTelRep;
	}
	
	public Set<SoumissionnaireTypeMarche> getSoumissionnaireTypeMarche() {
		return soumissionnaireTypeMarche;
	}

	public void setSoumissionnaireTypeMarche(Set<SoumissionnaireTypeMarche> soumissionnaireTypeMarche) {
		this.soumissionnaireTypeMarche = soumissionnaireTypeMarche;
	}

	 public Etat getEtat() { 
		 return etat; 
     }
	 
	 public void setEtat(Etat etat) {
		 this.etat = etat;
	 }
	
	public Gouvernerat getGouvernorat() {
		return gouvernorat;
	}

    public Etat getSoumissionnaireEtatCompte() {
    	return soumissionnaireEtatCompte;
    }
	  
	public void setSoumissionnaireEtatCompte(Etat soumissionnaireEtatCompte) {
	  this.soumissionnaireEtatCompte = soumissionnaireEtatCompte;
	}
	 

	public void setGouvernorat(Gouvernerat gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public String getSoumissionnaireNumeroRegistreCommerce() {
		return soumissionnaireNumeroRegistreCommerce;
	}

	public void setSoumissionnaireNumeroRegistreCommerce(String soumissionnaireNumeroRegistreCommerce) {
		this.soumissionnaireNumeroRegistreCommerce = soumissionnaireNumeroRegistreCommerce;
	}

	public Integer getCodePostaleId() {
		return codePostaleId;
	}

	public void setCodePostaleId(Integer codePostaleId) {
		this.codePostaleId = codePostaleId;
	}

	public String getSoumissionnaireAutreAdresse() {
		return soumissionnaireAutreAdresse;
	}

	public void setSoumissionnaireAutreAdresse(String soumissionnaireAutreAdresse) {
		this.soumissionnaireAutreAdresse = soumissionnaireAutreAdresse;
	}

	public RepresentantLegalTitre getSoumissionnaireRepresentantLegalTitre() {
		return soumissionnaireRepresentantLegalTitre;
	}

	public void setSoumissionnaireRepresentantLegalTitre(RepresentantLegalTitre soumissionnaireRepresentantLegalTitre) {
		this.soumissionnaireRepresentantLegalTitre = soumissionnaireRepresentantLegalTitre;
	}
	public Integer getSoumissionnaireBoitePosteId() {
		return soumissionnaireBoitePosteId;
	}

	public void setSoumissionnaireBoitePosteId(Integer soumissionnaireBoitePosteId) {
		this.soumissionnaireBoitePosteId = soumissionnaireBoitePosteId;
	}
	public Integer getSoumissionnaireGenre() {
		return soumissionnaireGenre;
	}

	public void setSoumissionnaireGenre(Integer soumissionnaireGenre) {
		this.soumissionnaireGenre = soumissionnaireGenre;
	}

	public Boolean getSoumissionnaireAvecInscription() {
		return soumissionnaireAvecInscription;
	}

	public void setSoumissionnaireAvecInscription(Boolean soumissionnaireAvecInscription) {
		this.soumissionnaireAvecInscription = soumissionnaireAvecInscription;
	}


	
}
