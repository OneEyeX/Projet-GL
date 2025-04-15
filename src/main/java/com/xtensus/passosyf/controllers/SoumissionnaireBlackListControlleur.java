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

import com.xtensus.passosyf.entities.SoumissionnaireBlackList;
import com.xtensus.passosyf.services.SoumissionnaireBlackListService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "SoumissionnaireBlackList")
public class SoumissionnaireBlackListControlleur {

	@Autowired
	private SoumissionnaireBlackListService soumissionnaireBlackListService;
	
	
	@GetMapping(value="/getSoumissionnaireBlackLists",  produces = "application/json")
	public List<SoumissionnaireBlackList> getAllSoumissionnaireBlackLists(){

		return soumissionnaireBlackListService.getAllSoumissionnaireBlackLists();
	}
	
	
	@GetMapping(value="/getSoumissionnaireBlackListById/{id}")
	public SoumissionnaireBlackList getSoumissionnaireBlackListById(@PathVariable int id) {

		return soumissionnaireBlackListService.getSoumissionnaireBlackListById(id);
	}
	
	
	@PostMapping(value="/addSoumissionnaireBlackList")
	public void addSoumissionnaireBlackList(@RequestBody SoumissionnaireBlackList soumissionnaireBlackList){
	
		soumissionnaireBlackListService.saveSoumissionnaireBlackList(soumissionnaireBlackList);

	}
	
	@DeleteMapping(value="/deleteSoumissionnaireBlackListById/{id}")
	public void deleteSoumissionnaireBlackListById(@PathVariable int id) {
		
		soumissionnaireBlackListService.deleteSoumissionnaireBlackListById(id);
	}
	
	@PutMapping(value="/updateSoumissionnaireBlackList")
	public void updateSoumissionnaireBlackList(@RequestBody SoumissionnaireBlackList soumissionnaireBlackList) {
		
		soumissionnaireBlackListService.saveSoumissionnaireBlackList(soumissionnaireBlackList);

	}
}
