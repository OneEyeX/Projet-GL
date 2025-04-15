package com.xtensus.passosyf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xtensus.passosyf.entities.Civilite;
import com.xtensus.passosyf.services.CiviliteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Civilite")
public class CiviliteControlleur {
	
	@Autowired
	private CiviliteService civiliteService;
	

	@GetMapping(value="/getCivilites",  produces = "application/json")
	public List<Civilite> getAllCivilites(){

		return civiliteService.getAllCivilites();
	}
	
	
	@GetMapping(value="/getCiviliteById/{id}")
	public Civilite getCiviliteById(@PathVariable int id) {

		return civiliteService.getCiviliteByIdById(id);
	}
	
	
	@PostMapping(value="/addCivilite")
	public void addCivilite(@RequestBody Civilite civilite){
	
		civiliteService.saveCivilite(civilite);

	}
	
	@DeleteMapping(value="/deleteCiviliteById/{id}")
	public void deleteCiviliteById(@PathVariable int id) {
		
		civiliteService.deleteCiviliteById(id);
	}
	
	@PutMapping(value="/updateCivilite")
	public void updateCivilite(@RequestBody Civilite civilite) {
		
		civiliteService.saveCivilite(civilite);

	}
	

	

}
