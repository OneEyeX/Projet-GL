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

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.CahierCharges;
import com.xtensus.passosyf.services.AppelOffresService;
import com.xtensus.passosyf.services.CahierChargesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "CahierCharges")
public class CahierChargesControlleur {

	@Autowired
	private CahierChargesService cahierChargesService;
	
	@Autowired
	private AppelOffresService appelOffresService;
	
	@GetMapping(value="/getCahierCharges",  produces = "application/json")
	public List<CahierCharges> getAllCahierCharges(){

		return cahierChargesService.getAllCahierCharges();
	}
	
	
	@GetMapping(value="/getCahierChargesById/{id}")
	public CahierCharges getCahierChargesById(@PathVariable int id) {

		return cahierChargesService.getCahierChargesById(id);
	}
	
	
	@PostMapping(value="/addCahierCharges")
	public void addCahierCharges(@RequestBody CahierCharges cahierCharges){
	
		cahierChargesService.saveCahierCharges(cahierCharges);

	}
	
	@DeleteMapping(value="/deleteCahierChargesById/{id}")
	public void deleteCahierChargesById(@PathVariable int id) {
		

		cahierChargesService.deleteCahierChargesById(id);
	}
	
	@PutMapping(value="/updateCahierCharges")
	public void updateCahierCharges(@RequestBody CahierCharges cahierCharges) {
		
		cahierChargesService.saveCahierCharges(cahierCharges);

	}
	
	@GetMapping(value="/getUnaffectedCahierCharges")
	public List<CahierCharges> getUnaffectedCahierCharges() {

		return cahierChargesService.getCahierChargesByAppelOffre(null);
	}
	
	@PutMapping(value="/setAppelOffresToCahierCharges/{aoId}/{ccId}")
	public void setAppelOffresToCahierCharges(@PathVariable int aoId,@PathVariable int ccId) {
		
		
		AppelOffres appelOffre=appelOffresService.getAppelOffresById(aoId);
		CahierCharges cahierCharges=cahierChargesService.getCahierChargesById(ccId);
		cahierCharges.setAppelOffre(appelOffre);
		cahierChargesService.saveCahierCharges(cahierCharges);

	}
	
	@GetMapping(value="/isAppelOffreAffected/{aoId}")
	public boolean isAppelOffreAffected(@PathVariable int aoId) {

		CahierCharges cahierCharges = cahierChargesService.getCahierChargesByAppelOffreId(aoId);
		if (cahierCharges==null) 
		{
			return false;
		}
		return true;
	}
	
}
