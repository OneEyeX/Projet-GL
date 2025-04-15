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

import com.xtensus.passosyf.entities.ModeReglement;
import com.xtensus.passosyf.services.ModeReglementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "ModeReglement")
public class ModeReglementControlleur {
	
	@Autowired
	private ModeReglementService modeReglementService;
	
	
	@GetMapping(value="/getModeReglements",  produces = "application/json")
	public List<ModeReglement> getAllModeReglements(){

		return modeReglementService.getAllModeReglements();
	}
	
	
	@GetMapping(value="/getModeReglementById/{id}")
	public ModeReglement getModeReglementById(@PathVariable int id) {

		return modeReglementService.getModeReglementById(id);
	}
	
	
	@PostMapping(value="/addModeReglement")
	public void addModeReglement(@RequestBody ModeReglement modeReglement){
	
		modeReglementService.saveModeReglement(modeReglement);

	}
	
	@DeleteMapping(value="/deleteModeReglementById/{id}")
	public void deleteModeReglementById(@PathVariable int id) {
		
		modeReglementService.deleteModeReglementById(id);
	}
	
	@PutMapping(value="/updateModeReglement")
	public void updateModeReglement(@RequestBody ModeReglement modeReglement) {
		
		modeReglementService.saveModeReglement(modeReglement);

	}

}
