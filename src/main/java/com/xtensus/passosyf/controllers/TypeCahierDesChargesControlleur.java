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

import com.xtensus.passosyf.entities.TypeCahierDesCharges;
import com.xtensus.passosyf.services.TypeCahierDesChargesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TypeCahierDesCharges")
public class TypeCahierDesChargesControlleur {
	
	@Autowired
	private TypeCahierDesChargesService typeCahierDesChargesService;
	
	
	@GetMapping(value="/getTypeCahierDesCharges",  produces = "application/json")
	public List<TypeCahierDesCharges> getAllTypeCahierDesChargess(){

		return typeCahierDesChargesService.getAllTypeCahierDesCharges();
	}
	
	
	@GetMapping(value="/getTypeCahierDesChargesById/{id}")
	public TypeCahierDesCharges getTypeCahierDesChargesById(@PathVariable int id) {

		return typeCahierDesChargesService.getTypeCahierDesChargesById(id);
	}
	
	@PostMapping(value="/addTypeCahierDesCharges")
	public void addTypeCahierDesCharges(@RequestBody TypeCahierDesCharges typeCahierDesCharges){
	
		typeCahierDesChargesService.saveTypeCahierDesCharges(typeCahierDesCharges);

	}
	
	@DeleteMapping(value="/deleteTypeCahierDesChargesById/{id}")
	public void deleteTypeCahierDesChargesById(@PathVariable int id) {
		
		typeCahierDesChargesService.deleteTypeCahierDesChargesById(id);
	}
	
	@PutMapping(value="/updateTypeCahierDesCharges")
	public void updateTypeCahierDesCharges(@RequestBody TypeCahierDesCharges typeCahierDesCharges) {
		
		typeCahierDesChargesService.saveTypeCahierDesCharges(typeCahierDesCharges);
	}

}
