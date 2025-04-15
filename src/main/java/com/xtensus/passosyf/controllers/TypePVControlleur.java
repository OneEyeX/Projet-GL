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

import com.xtensus.passosyf.entities.TypePV;
import com.xtensus.passosyf.services.TypePVService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TypePV")
public class TypePVControlleur {

	@Autowired
	private TypePVService typePVService;
	
	
	@GetMapping(value="/getTypePVs",  produces = "application/json")
	public List<TypePV> getAllTypePVs(){

		return typePVService.getAllTypePVs();
	}
	
	
	@GetMapping(value="/getTypePVById/{id}")
	public TypePV getTypePVById(@PathVariable int id) {

		return typePVService.getTypePVById(id);
	}
	
	
	@PostMapping(value="/addTypePV")
	public void addTypePV(@RequestBody TypePV typePV){
	
		typePVService.saveTypePV(typePV);

	}
	
	@DeleteMapping(value="/deleteTypePVById/{id}")
	public void deleteTypePVById(@PathVariable int id) {
		
		typePVService.deleteTypePVById(id);
	}
	
	@PutMapping(value="/updateTypePV")
	public void updateTypePV(@RequestBody TypePV typePV) {
		
		typePVService.saveTypePV(typePV);

	}
}
