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

import com.xtensus.passosyf.entities.Motif;
import com.xtensus.passosyf.services.MotifService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Motif")
public class MotifControlleur {
	
	@Autowired
	private MotifService motifService;
	
	
	@GetMapping(value="/getMotifs",  produces = "application/json")
	public List<Motif> getAllMotifs(){

		return motifService.getAllMotifs();
	}
	
	
	@GetMapping(value="/getMotifById/{id}")
	public Motif getMotifById(@PathVariable int id) {

		return motifService.getMotifById(id);
	}
	
	
	@PostMapping(value="/addMotif")
	public void addMotif(@RequestBody Motif motif){
	
		motifService.saveMotif(motif);

	}
	
	@DeleteMapping(value="/deleteMotifById/{id}")
	public void deleteMotifById(@PathVariable int id) {
		
		motifService.deleteMotifById(id);
	}
	
	@PutMapping(value="/updateMotif")
	public void updateMotif(@RequestBody Motif motif) {
		
		motifService.saveMotif(motif);

	}

}
