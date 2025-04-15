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

import com.xtensus.passosyf.entities.SecteurActivite;
import com.xtensus.passosyf.services.SecteurActiviteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "SecteurActivite")
public class SecteurActiviteControlleur {
	
	@Autowired
	private SecteurActiviteService secteurActiviteService;
	
	
	@GetMapping(value="/getSecteurActivites",  produces = "application/json")
	public List<SecteurActivite> getAllSecteurActivites(){

		return secteurActiviteService.getAllSecteurActivites();
	}
	
	
	@GetMapping(value="/getSecteurActiviteById/{id}")
	public SecteurActivite getSecteurActiviteById(@PathVariable int id) {

		return secteurActiviteService.getSecteurActiviteById(id);
	}
	
	
	@PostMapping(value="/addSecteurActivite")
	public void addSecteurActivite(@RequestBody SecteurActivite secteurActivite){
	
		secteurActiviteService.saveSecteurActivite(secteurActivite);

	}
	
	@DeleteMapping(value="/deleteSecteurActiviteById/{id}")
	public void deleteSecteurActiviteById(@PathVariable int id) {
		
		secteurActiviteService.deleteSecteurActiviteById(id);
	}
	
	@PutMapping(value="/updateSecteurActivite")
	public void updateSecteurActivite(@RequestBody SecteurActivite secteurActivite) {
		
		secteurActiviteService.saveSecteurActivite(secteurActivite);

	}

}
