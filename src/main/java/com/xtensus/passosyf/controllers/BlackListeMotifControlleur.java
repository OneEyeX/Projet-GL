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

import com.xtensus.passosyf.entities.BlackListeMotif;
import com.xtensus.passosyf.services.BlackListeMotifService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "BlackListeMotif")
public class BlackListeMotifControlleur {

	@Autowired
	private BlackListeMotifService blackListeMotifService;
	
	
	@GetMapping(value="/getBlackListeMotifs",  produces = "application/json")
	public List<BlackListeMotif> getAllBlackListeMotifs(){

		return blackListeMotifService.getAllBlackListeMotifs();
	}
	
	
	@GetMapping(value="/getBlackListeMotifById/{id}")
	public BlackListeMotif getBlackListeMotifById(@PathVariable int id) {

		return blackListeMotifService.getBlackListeMotifById(id);
	}
	
	
	@PostMapping(value="/addBlackListeMotif")
	public void addBlackListeMotif(@RequestBody BlackListeMotif blackListeMotif){
	
		blackListeMotifService.saveBlackListeMotif(blackListeMotif);

	}
	
	@DeleteMapping(value="/deleteBlackListeMotifById/{id}")
	public void deleteBlackListeMotifById(@PathVariable int id) {
		
		blackListeMotifService.deleteBlackListeMotifById(id);
	}
	
	@PutMapping(value="/updateBlackListeMotif")
	public void updateBlackListeMotif(@RequestBody BlackListeMotif blackListeMotif) {
		
		blackListeMotifService.saveBlackListeMotif(blackListeMotif);

	}
}
