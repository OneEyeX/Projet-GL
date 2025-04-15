package com.xtensus.passosyf.controllers;

import java.util.List;
import java.util.Set;

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

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Ville;
import com.xtensus.passosyf.services.GouverneratService;
import com.xtensus.passosyf.services.VilleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Ville")
public class VilleControlleur {
	
	@Autowired
	private VilleService villeService;
	
	@Autowired 
	private GouverneratService gouverneratService;
	
	
	@GetMapping(value="/getVilles",  produces = "application/json")
	public List<Ville> getAllVilles(){

		return villeService.getAllVilles();
	}
	
	
	@GetMapping(value="/getVilleById/{id}")
	public Ville getVilleById(@PathVariable int id) {

		return villeService.getVilleById(id);
	}
	
	
	@PostMapping(value="/addVille")
	public void addVille(@RequestBody Ville ville){
	
		villeService.saveVille(ville);

	}
	
	@DeleteMapping(value="/deleteVilleById/{id}")
	public void deleteVilleById(@PathVariable int id) {
		

		villeService.deleteVilleById(id);
	}
	
	@PutMapping(value="/updateVille")
	public void updateVille(@RequestBody Ville ville) {
		
		villeService.saveVille(ville);

	}
	
	
	
	@GetMapping(value="/getVilles/byGouverneratId/{id}")
	public Set < Ville> getVillesByGouverneratId(@PathVariable int id) {
		
		Gouvernerat gouvernerat = gouverneratService.getGouverneratById(id);
		return villeService.getVillesByGouvernerat(gouvernerat);
	}
	
	@PostMapping(value="/addVille/toGouvernerat")
	public void addVilleToGouvernerat(@RequestBody Ville ville){
		
		villeService.saveVille(ville);

	}


}
