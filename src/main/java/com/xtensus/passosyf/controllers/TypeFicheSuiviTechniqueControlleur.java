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

import com.xtensus.passosyf.entities.TypeFicheSuiviTechnique;
import com.xtensus.passosyf.services.TypeFicheSuiviTechniqueService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "TypeFicheSuiviTechnique")
public class TypeFicheSuiviTechniqueControlleur {
	
	@Autowired
	private TypeFicheSuiviTechniqueService typeFicheSuiviTechniqueService;
	
	
	@GetMapping(value="/getTypeFicheSuiviTechniques",  produces = "application/json")
	public List<TypeFicheSuiviTechnique> getAllTypeFicheSuiviTechniques(){

		return typeFicheSuiviTechniqueService.getAllTypeFicheSuiviTechniques();
	}
	
	
	@GetMapping(value="/getTypeFicheSuiviTechniqueById/{id}")
	public TypeFicheSuiviTechnique getTypeFicheSuiviTechniqueById(@PathVariable int id) {

		return typeFicheSuiviTechniqueService.getTypeFicheSuiviTechniqueById(id);
	}
	
	@PostMapping(value="/addTypeFicheSuiviTechnique")
	public void addTypeFicheSuiviTechnique(@RequestBody TypeFicheSuiviTechnique typeFicheSuiviTechnique){
	
		typeFicheSuiviTechniqueService.saveTypeFicheSuiviTechnique(typeFicheSuiviTechnique);

	}
	
	@DeleteMapping(value="/deleteTypeFicheSuiviTechniqueById/{id}")
	public void deleteTypeFicheSuiviTechniqueById(@PathVariable int id) {

		typeFicheSuiviTechniqueService.deleteTypeFicheSuiviTechniqueById(id);
	}
	
	@PutMapping(value="/updateTypeFicheSuiviTechnique")
	public void updateTypeFicheSuiviTechnique(@RequestBody TypeFicheSuiviTechnique typeFicheSuiviTechnique) {
		
		typeFicheSuiviTechniqueService.saveTypeFicheSuiviTechnique(typeFicheSuiviTechnique);
	}

}
