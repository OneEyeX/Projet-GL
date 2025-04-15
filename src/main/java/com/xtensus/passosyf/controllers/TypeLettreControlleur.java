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

import com.xtensus.passosyf.entities.TypeLettre;
import com.xtensus.passosyf.services.TypeLettreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TypeLettre")
public class TypeLettreControlleur {
	
	@Autowired
	private TypeLettreService typeLettreService;
	
	
	@GetMapping(value="/getTypeLettres",  produces = "application/json")
	public List<TypeLettre> getAllTypeLettres(){

		return typeLettreService.getAllTypeLettres();
	}
	
	
	@GetMapping(value="/getTypeLettreById/{id}")
	public TypeLettre getTypeLettreById(@PathVariable int id) {

		return typeLettreService.getTypeLettreById(id);
	}
	
	@PostMapping(value="/addTypeLettre")
	public void addTypeLettre(@RequestBody TypeLettre typeLettre){
	
		typeLettreService.saveTypeLettre(typeLettre);

	}
	
	@DeleteMapping(value="/deleteTypeLettreById/{id}")
	public void deleteTypeLettreById(@PathVariable int id) {

		typeLettreService.deleteTypeLettreById(id);
	}
	
	@PutMapping(value="/updateTypeLettre")
	public void updateTypeLettre(@RequestBody TypeLettre typeLettre) {
		
		typeLettreService.saveTypeLettre(typeLettre);
	}



}



