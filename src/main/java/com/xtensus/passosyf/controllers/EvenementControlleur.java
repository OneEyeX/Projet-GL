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

import com.xtensus.passosyf.entities.Evenement;
import com.xtensus.passosyf.services.EvenementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Evenement")
public class EvenementControlleur {

	@Autowired
	private EvenementService evenementService;
	
	
	@GetMapping(value="/getEvenements",  produces = "application/json")
	public List<Evenement> getAllEvenements(){

		return evenementService.getAllEvenements();
	}
	
	
	@GetMapping(value="/getEvenementById/{id}")
	public Evenement getEvenementById(@PathVariable int id) {

		return evenementService.getEvenementById(id);
	}
	
	
	@PostMapping(value="/addEvenement")
	public void addEvenement(@RequestBody Evenement evenement){
	
		evenementService.saveEvenement(evenement);

	}
	
	@DeleteMapping(value="/deleteEvenementById/{id}")
	public void deleteEvenementById(@PathVariable int id) {
		

		evenementService.deleteEvenementById(id);
	}
	
	@PutMapping(value="/updateEvenement")
	public void updateEvenement(@RequestBody Evenement evenement) {
		
		evenementService.saveEvenement(evenement);

	}
}
