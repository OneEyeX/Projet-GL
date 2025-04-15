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

import com.xtensus.passosyf.entities.TypeCritere;
import com.xtensus.passosyf.services.TypeCritereService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TypeCritere")
public class TypeCritereControlleur {
	
	@Autowired
	private TypeCritereService typeCritereService;
	
	@GetMapping(value="/getTypeCriteres",  produces = "application/json")
	public List<TypeCritere> getAllTypeCriteres(){

		return typeCritereService.getAllTypeCriteres();
	}
	
	
	@GetMapping(value="/getTypeCritereById/{id}")
	public TypeCritere getTypeCritereById(@PathVariable int id) {

		return typeCritereService.getTypeCritereById(id);
	}
	
	@PostMapping(value="/addTypeCritere")
	public void addTypeCritere(@RequestBody TypeCritere typeCritere){
	
		typeCritereService.saveTypeCritere (typeCritere);

	}
	
	@DeleteMapping(value="/deleteTypeCritereById/{id}")
	public void deleteTypeCritereById(@PathVariable int id) {
		
		typeCritereService.deleteTypeCritereById(id);
	}
	
	@PutMapping(value="/updateTypeCritere")
	public void updateTypeCritere (@RequestBody TypeCritere typeCritere) {
		
		typeCritereService.saveTypeCritere (typeCritere);
	}

}
