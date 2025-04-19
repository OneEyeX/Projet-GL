package com.xtensus.passosyf.services;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.xtensus.passosyf.entities.Soumissionnaire;

import net.sf.jasperreports.engine.JRException;

public interface SoumissionnaireService {
	
	public List<Soumissionnaire> ajouter(Soumissionnaire t) ;
	
	public Soumissionnaire save(Soumissionnaire soumissionnaire) ;
	
	public List<Soumissionnaire> getAll();
	
	//public byte[] exportListeSoumissionnaires () throws FileNotFoundException, JRException;
	
	public Page<Soumissionnaire> findAll(int pageNum,int pageSize, String sortDir, String sortField,String search);
	
	public List<Soumissionnaire> supprimer(int id) ;
	
	public Soumissionnaire getone(int id);
	
	public void update(Soumissionnaire t1);
	
	public Soumissionnaire changeEtatCompte(int soummissionReference,int etatId);
	
	public Page<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreReference,int pageNum,int pageSize, String sortDir, String sortField,String search);
	
	public List<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreReference);

	public Soumissionnaire  findSoumissionnaireByMatricule(String matricule);

	public Integer isUsedBySoumissionnaireId(Integer soumissionnaireId);

	byte[] exportListeSoumissionnaires(String format) throws FileNotFoundException, JRException;
}
