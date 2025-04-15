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

import com.xtensus.passosyf.entities.EvenementType;
import com.xtensus.passosyf.services.EvenementTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "EvenementType")
public class EvenementTypeControlleur {

	@Autowired
	private EvenementTypeService evenementTypeService;
	
	
	@GetMapping(value="/getEvenementTypes",  produces = "application/json")
	public List<EvenementType> getAllEvenementTypes(){

		return evenementTypeService.getAllEvenementTypes();
	}
	
	
	@GetMapping(value="/getEvenementTypeById/{id}")
	public EvenementType getEvenementTypeById(@PathVariable int id) {

		return evenementTypeService.getEvenementTypeById(id);
	}
	
	
	@PostMapping(value="/addEvenementType")
	public void addEvenementType(@RequestBody EvenementType evenementType){
	
		evenementTypeService.saveEvenementType(evenementType);

	}
	
	@DeleteMapping(value="/deleteEvenementTypeById/{id}")
	public void deleteEvenementTypeById(@PathVariable int id) {
		

		evenementTypeService.deleteEvenementTypeById(id);
	}
	
	@PutMapping(value="/updateEvenementType")
	public void updateEvenementType(@RequestBody EvenementType evenementType) {
		
		evenementTypeService.saveEvenementType(evenementType);

	}
}
