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

import com.xtensus.passosyf.entities.TauxTVA;
import com.xtensus.passosyf.services.TauxTVAService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TauxTVA")
public class TauxTVAControlleur {
	@Autowired
	private TauxTVAService tauxTVAService;
	
	
	@GetMapping(value="/getTauxTVAs",  produces = "application/json")
	public List<TauxTVA> getAllTauxTVAs(){

		return tauxTVAService.getAllTauxTVAs();
	}
	
	
	@GetMapping(value="/getTauxTVAById/{id}")
	public TauxTVA getTauxTVAById(@PathVariable int id) {

		return tauxTVAService.getTauxTVAById(id);
	}
	
	
	@PostMapping(value="/addTauxTVA")
	public void addTauxTVA(@RequestBody TauxTVA tauxTVA){
	
		tauxTVAService.saveTauxTVA(tauxTVA);

	}
	
	@DeleteMapping(value="/deleteTauxTVAById/{id}")
	public void deleteTauxTVAById(@PathVariable int id) {
		
		tauxTVAService.deleteTauxTVAById(id);
	}
	
	@PutMapping(value="/updateTauxTVA")
	public void updateTauxTVA(@RequestBody TauxTVA tauxTVA) {
		
		tauxTVAService.saveTauxTVA(tauxTVA);

	}
}
