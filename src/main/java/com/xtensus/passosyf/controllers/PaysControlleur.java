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

import com.xtensus.passosyf.entities.Pays;
import com.xtensus.passosyf.services.PaysService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Pays")
public class PaysControlleur {

	@Autowired
	PaysService paysService;


	@GetMapping(value = "/getPays")
	public List<Pays> getAllPays() {
		
		return paysService.getAllPays();
	}
	
	
	@GetMapping(value = "/getPaysById/{id}")
	public Pays getPaysById(@PathVariable(name="id") int id) {
		
		return paysService.getPaysById(id);

	}
	

	@PostMapping("/addPays")
	public void addPays(@RequestBody Pays pays) {	
		
		paysService.savePays(pays);

	}
	
	
	@DeleteMapping(value = "/deletePaysById/{id}")
	public void deletePaysById(@PathVariable  int id) {
		
		paysService.deletePaysById(id);
		
		
	}


	@PutMapping("/updatePays")
	public Pays updatePays( @RequestBody Pays pays) {
		
		return paysService.savePays(pays);
	}


}
