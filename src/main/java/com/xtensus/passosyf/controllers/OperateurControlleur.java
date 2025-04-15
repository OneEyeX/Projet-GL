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

import com.xtensus.passosyf.entities.Operateur;
import com.xtensus.passosyf.services.OperateurService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Operateur")
public class OperateurControlleur {
	
	@Autowired
	private OperateurService operateurService;
	
	
	@GetMapping(value="/getOperateurs",  produces = "application/json")
	public List<Operateur> getAllOperateurs(){

		return operateurService.getAllOperateurs();
	}
	
	
	@GetMapping(value="/getOperateurById/{id}")
	public Operateur getOperateurById(@PathVariable int id) {

		return operateurService.getOperateurById(id);
	}
	
	@PostMapping(value="/addOperateur")
	public void addOperateur(@RequestBody Operateur operateur){
	
		operateurService.saveOperateur(operateur);

	}
	
	@DeleteMapping(value="/deleteOperateurById/{id}")
	public void deleteOperateurById(@PathVariable int id) {
		
		operateurService.deleteOperateurById(id);
	}
	
	@PutMapping(value="/updateOperateur")
	public void updateOperateur(@RequestBody Operateur operateur) {
		
		operateurService.saveOperateur(operateur);
	}
	
	

}
