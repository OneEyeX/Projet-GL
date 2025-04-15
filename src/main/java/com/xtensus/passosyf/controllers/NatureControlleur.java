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


import com.xtensus.passosyf.entities.Nature;
import com.xtensus.passosyf.services.NatureService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Nature")
public class NatureControlleur {
	
	@Autowired
	private NatureService natureService;
	
	
	@GetMapping(value="/getNatures",  produces = "application/json")
	public List<Nature> getAllNatures(){

		return natureService.getAllNatures();
	}
	
	
	@GetMapping(value="/getNatureById/{id}")
	public Nature getNatureById(@PathVariable int id) {

		return natureService.getNatureById(id);
	}
	
	@PostMapping(value="/addNature")
	public void addNature(@RequestBody Nature nature){
	
		natureService.saveNature(nature);

	}
	
	@DeleteMapping(value="/deleteNatureById/{id}")
	public void deleteNatureById(@PathVariable int id) {
		

		natureService.deleteNatureById(id);
	}
	
	@PutMapping(value="/updateNature")
	public void updateNature(@RequestBody Nature nature) {
		
		natureService.saveNature(nature);
	}



}
