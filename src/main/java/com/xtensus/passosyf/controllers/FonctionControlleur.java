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

import com.xtensus.passosyf.entities.Fonction;
import com.xtensus.passosyf.services.FonctionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Fonction")
public class FonctionControlleur {

	@Autowired
	private FonctionService fonctionService;
	
	
	@GetMapping(value="/getFonctions",  produces = "application/json")
	public List<Fonction> getAllFonctions(){

		return fonctionService.getAllFonctions();
	}
	
	
	@GetMapping(value="/getFonctionById/{id}")
	public Fonction getFonctionById(@PathVariable int id) {

		return fonctionService.getFonctionById(id);
	}
	
	
	@PostMapping(value="/addFonction")
	public void addFonction(@RequestBody Fonction fonction){
	
		fonctionService.saveFonction(fonction);

	}
	
	@DeleteMapping(value="/deleteFonctionById/{id}")
	public void deleteFonctionById(@PathVariable int id) {
		

		fonctionService.deleteFonctionById(id);
	}
	
	@PutMapping(value="/updateFonction")
	public void updateFonction(@RequestBody Fonction fonction) {
		
		fonctionService.saveFonction(fonction);

	}
}
