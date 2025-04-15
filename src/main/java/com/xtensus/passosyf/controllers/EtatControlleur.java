package com.xtensus.passosyf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.entities.EtatCategorie;
import com.xtensus.passosyf.services.EtatCategorieService;
import com.xtensus.passosyf.services.EtatService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Etat")
public class EtatControlleur {
	
	@Autowired
	private EtatCategorieService etatCategorieService;
	
	@Autowired
	private EtatService etatService;
	
	
	@GetMapping(value="/getEtats",  produces = "application/json")
	public List<Etat> getAllEtats(){

		return etatService.getAllEtats();
	}
	
	
	@GetMapping(value="/getEtatById/{id}")
	public Etat getEtatById(@PathVariable int id) {

		return etatService.getEtatById(id);
	}
	
	
	@PostMapping(value="/addEtat")
	public void addEtat(@RequestBody Etat etat){
	
		etatService.saveEtat(etat);

	}
	
	@DeleteMapping(value="/deleteEtatById/{id}")
	public void deleteEtatById(@PathVariable int id) {
		
		etatService.deleteEtatById(id);
	}
	
	@PutMapping(value="/updateEtat")
	public void updateEtat(@RequestBody Etat etat) {
		
		etatService.saveEtat(etat);

	}
	
	@GetMapping(value="/getEtats/ByEtatCategorieLibelle/{libelle}",  produces = "application/json")
	public List<Etat> getEtatsByEtatCategorieLibelle(@PathVariable String libelle){

		EtatCategorie etatCategorie = etatCategorieService.getEtatCategorieByEtatCategorieLibelle(libelle);
		return etatService.getEtatsByEtatCategorie(etatCategorie);
	}

}
