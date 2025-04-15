package com.xtensus.passosyf.controllers;

import java.util.List;
import java.util.Set;

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

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Pays;
import com.xtensus.passosyf.services.GouverneratService;
import com.xtensus.passosyf.services.PaysService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Gouvernerat")
public class GouverneratControlleur {
	
	@Autowired
	private GouverneratService gouverneratService;
	
	@Autowired
	private PaysService paysService;
	
	
	@GetMapping(value="/getGouvernerats",  produces = "application/json")
	public List<Gouvernerat> getAllGouvernerats(){

		return gouverneratService.getAllGouvernerats();
	}
	
	
	@GetMapping(value="/getGouverneratById/{id}")
	public Gouvernerat getGouverneratById(@PathVariable int id) {

		return gouverneratService.getGouverneratById(id);
	}
	
	@PostMapping(value="/addGouvernerat")
	public void saveGouvernerat(@RequestBody Gouvernerat gouvernerat){
	
		gouverneratService.saveGouvernerat(gouvernerat);

	}
	
	@DeleteMapping(value="/deleteGouverneratById/{id}")
	public void deleteGouverneratById(@PathVariable int id) {
		
		gouverneratService.deleteGouverneratById(id);
	}
	
	@PutMapping(value="/updateGouvernerat")
	public void updateGouvernerat(@RequestBody Gouvernerat gouvernerat) {
		
		gouverneratService.saveGouvernerat(gouvernerat);

	}

	
	@GetMapping(value="/getGouvernerats/byPaysId/{id}")
	public Set <Gouvernerat > getGouverneratsByPaysId(@PathVariable int id) {
		
		Pays pays = paysService.getPaysById(id);
		return gouverneratService.getAllGouverneratsByPays(pays);
	}
	
	@PostMapping(value="/addGouvernerat/toPays")
	public void addGouverneratToPays(@RequestBody Gouvernerat gouvernerat){
		
		gouverneratService.saveGouvernerat(gouvernerat);

	}
	


}
