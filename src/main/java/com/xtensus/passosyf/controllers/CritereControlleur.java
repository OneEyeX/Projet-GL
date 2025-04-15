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

import com.xtensus.passosyf.entities.Critere;
import com.xtensus.passosyf.services.CritereService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Critere")
public class CritereControlleur {
	
	@Autowired
	CritereService critereService;


	@GetMapping(value = "/getCriteres")
	public List<Critere> getAllCritere() {
		
		return critereService.getAllCritere();
	}
	
	
	@GetMapping(value = "/getCritereById/{id}")
	public Critere getCritereById(@PathVariable(name="id") int id) {
		
		return critereService.getCritereById(id);
	}
	

	@PostMapping("/addCritere")
	public void addCritere(@RequestBody Critere critere) {	
		
		critereService.saveCritere(critere);

	}
	
	
	@DeleteMapping(value = "/deleteCritereById/{id}")
	public void deleteCritereById(@PathVariable int id) {
		
		 critereService.deleteCritereById(id);
	}



	@PutMapping("/updateCritere")
	public Critere updateCritere( @RequestBody Critere critere) {
		
		return critereService.saveCritere(critere);
	}

}
