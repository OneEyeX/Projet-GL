package com.xtensus.passosyf.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xtensus.passosyf.entities.Devise;
import com.xtensus.passosyf.services.DeviseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Devise")
public class DeviseControlleur {

	@Autowired
	private DeviseService deviseService;
	
	
	@GetMapping(value="/getDevises",  produces = "application/json")
	public Page <Devise> getAllDevises( @RequestParam(defaultValue = "0") int pageNum,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "deviseId") String sortField ,
                                        @RequestParam(defaultValue = "asc") String sortDir ,
                                        @RequestParam(required = false) String search){
		
	    Page<Devise> devisesPage;
	    if (search != null && !search.isEmpty()) {
	        devisesPage = deviseService.searchDevises(search, pageNum, pageSize, sortField, sortDir);
	    } else {
	        devisesPage = deviseService.getAllDevises(pageNum, pageSize, sortField, sortDir);
	    }

        return devisesPage;
	}
	
	
	
	@GetMapping(value="/getDeviseById/{id}")
	public Devise getDeviseById(@PathVariable int id) {

		return deviseService.getDeviseById(id);
	}
	
	@PostMapping(value="/addDevise")
	public void addDevise(@RequestBody Devise devise){
	
		deviseService.saveDevise(devise);

	}
	
	@DeleteMapping(value="/deleteDeviseById/{id}")
	public void deleteDeviseById(@PathVariable int id) {
		
		deviseService.deleteDeviseById(id);
	}
	
	@PutMapping(value="/updateDevise")
	public void updateDevise(@RequestBody Devise devise) {
		
		deviseService.saveDevise(devise);
	}
}
