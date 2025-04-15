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

import com.xtensus.passosyf.entities.CategoriesProjet;
import com.xtensus.passosyf.services.CategoriesProjetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "CategoriesProjet")
public class CategoriesProjetControlleur {

	@Autowired
	private CategoriesProjetService categoriesProjetService;
	
	
	@GetMapping(value="/getCategoriesProjets",  produces = "application/json")
	public List<CategoriesProjet> getAllCategoriesProjets(){

		return categoriesProjetService.getAllCategoriesProjets();
	}
	
	
	@GetMapping(value="/getCategoriesProjetById/{id}")
	public CategoriesProjet getCategoriesProjetById(@PathVariable int id) {

		return categoriesProjetService.getCategoriesProjetById(id);
	}
	
	
	@PostMapping(value="/addCategoriesProjet")
	public void addCategoriesProjet(@RequestBody CategoriesProjet categoriesProjet){
	
		categoriesProjetService.saveCategoriesProjet(categoriesProjet);

	}
	
	@DeleteMapping(value="/deleteCategoriesProjetById/{id}")
	public void deleteCategoriesProjetById(@PathVariable int id) {
		

		categoriesProjetService.deleteCategoriesProjetById(id);
	}
	
	@PutMapping(value="/updateCategoriesProjet")
	public void updateCategoriesProjet(@RequestBody CategoriesProjet categoriesProjet) {
		
		categoriesProjetService.saveCategoriesProjet(categoriesProjet);

	}
}
