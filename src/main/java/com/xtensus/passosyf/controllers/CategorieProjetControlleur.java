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

import com.xtensus.passosyf.entities.CategorieProjet;
import com.xtensus.passosyf.services.CategorieProjetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "CategorieProjet")
public class CategorieProjetControlleur {

	@Autowired
	private CategorieProjetService categorieProjetService;
	
	
	@GetMapping(value="/getCategorieProjets",  produces = "application/json")
	public List<CategorieProjet> getAllCategorieProjets(){

		return categorieProjetService.getAllCategorieProjets();
	}
	
	
	@GetMapping(value="/getCategorieProjetById/{id}")
	public CategorieProjet getCategorieProjetById(@PathVariable int id) {

		return categorieProjetService.getCategorieProjetById(id);
	}
	
	
	@PostMapping(value="/addCategorieProjet")
	public void addCategorieProjet(@RequestBody CategorieProjet categorieProjet){
	
		categorieProjetService.saveCategorieProjet(categorieProjet);

	}
	
	@DeleteMapping(value="/deleteCategorieProjetById/{id}")
	public void deleteCategorieProjetById(@PathVariable int id) {
		

		categorieProjetService.deleteCategorieProjetById(id);
	}
	
	@PutMapping(value="/updateCategorieProjet")
	public void updateCategorieProjet(@RequestBody CategorieProjet categorieProjet) {
		
		categorieProjetService.saveCategorieProjet(categorieProjet);

	}
}
