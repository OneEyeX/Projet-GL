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

import com.xtensus.passosyf.entities.Formejuridique;
import com.xtensus.passosyf.services.FormejuridiqueService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Formejuridique")
public class FormejuridiqueControlleur {

	@Autowired
	private FormejuridiqueService formejuridiqueService;
	
	
	@GetMapping(value="/getFormejuridiques",  produces = "application/json")
	public List<Formejuridique> getAllFormejuridiques(){

		return formejuridiqueService.getAllFormejuridiques();
	}
	
	
	@GetMapping(value="/getFormejuridiqueById/{id}")
	public Formejuridique getFormejuridiqueById(@PathVariable int id) {

		return formejuridiqueService.getFormejuridiqueById(id);
	}
	
	
	@PostMapping(value="/addFormejuridique")
	public void addFormejuridique(@RequestBody Formejuridique formejuridique){
	
		formejuridiqueService.saveFormejuridique(formejuridique);

	}
	
	@DeleteMapping(value="/deleteFormejuridiqueById/{id}")
	public void deleteFormejuridiqueById(@PathVariable int id) {
		

		formejuridiqueService.deleteFormejuridiqueById(id);
	}
	
	@PutMapping(value="/updateFormejuridique")
	public void updateFormejuridique(@RequestBody Formejuridique formejuridique) {
		
		formejuridiqueService.saveFormejuridique(formejuridique);

	}
}
