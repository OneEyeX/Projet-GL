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

import com.xtensus.passosyf.entities.NatureCritere;
import com.xtensus.passosyf.services.NatureCritereService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "NatureCritere")
public class NatureCritereControlleur {
	
	@Autowired
	private NatureCritereService natureCritereService;
	
	@GetMapping(value="/getNatureCriteres",  produces = "application/json")
	public List<NatureCritere> getAllNatureCriteres(){

		return natureCritereService.getAllNatureCriteres();
	}
	
	
	@GetMapping(value="/getNatureCritereById/{id}")
	public NatureCritere getNatureCritereById(@PathVariable int id) {

		return natureCritereService.getNatureCritereById(id);
	}
	
	@PostMapping(value="/addNatureCritere")
	public void addNatureCritere(@RequestBody NatureCritere natureCritere){
	
		natureCritereService.saveNatureCritere (natureCritere);

	}
	
	@DeleteMapping(value="/deleteNatureCritereById/{id}")
	public void deleteNatureCritereById(@PathVariable int id) {
		
		natureCritereService.deleteNatureCritereById(id);
	}
	
	@PutMapping(value="/updateNatureCritere")
	public void updateNatureCritere (@RequestBody NatureCritere natureCritere) {
		
		natureCritereService.saveNatureCritere (natureCritere);
	}

}
