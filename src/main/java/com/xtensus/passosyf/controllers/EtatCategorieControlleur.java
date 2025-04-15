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

import com.xtensus.passosyf.entities.EtatCategorie;
import com.xtensus.passosyf.services.EtatCategorieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/EtatCategorie")
public class EtatCategorieControlleur {
	
	@Autowired
	EtatCategorieService etatCategorieService;


	@GetMapping(value = "/getEtatCategories")
	public List<EtatCategorie> getAllEtatCategories() {
		
		return etatCategorieService.getAllEtatCategories();
	}
	
	
	@GetMapping(value = "/getEtatCategorieById/{id}")
	public EtatCategorie getEtatCategorieById(@PathVariable int id) {
		
		return etatCategorieService.getEtatCategorieById(id);
	}
	

	@PostMapping("/addEtatCategorie")
	public void addEtatCategorie(@RequestBody EtatCategorie etatCategorie) {	
		
		etatCategorieService.saveEtatCategorie(etatCategorie);

	}
	
	
	@DeleteMapping(value = "/deleteEtatCategorieById/{id}")
	public void  deleteEtatCategorieById(@PathVariable int id) {
		
		 etatCategorieService.deleteEtatCategorieById(id);
	}



	@PutMapping("/updateEtatCategorie")
	public EtatCategorie updateEtatCategorie( @RequestBody EtatCategorie etatCategorie) {
		
		return etatCategorieService.saveEtatCategorie(etatCategorie);

	}

}
