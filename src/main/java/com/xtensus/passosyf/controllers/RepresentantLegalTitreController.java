package com.xtensus.passosyf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtensus.passosyf.entities.RepresentantLegalTitre;
import com.xtensus.passosyf.services.RepresentantLegalTitreService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "TitreRepresentant")
public class RepresentantLegalTitreController {
	
	@Autowired
	RepresentantLegalTitreService representantLegalTitreService;
	
	  @GetMapping(path = "getAllTitreRepresentant")
	    public ResponseEntity<Iterable<RepresentantLegalTitre>> getAllRepresentantLegalTitre(){	
	      Iterable<RepresentantLegalTitre> representantLegalTitre=representantLegalTitreService.ListRepresentantLegalTitre();
	      return new ResponseEntity<>(representantLegalTitre,HttpStatus.OK);
	    }
	    
	  
	   @PostMapping(path = "addRepresentantLegalTitre")
	    public ResponseEntity<RepresentantLegalTitre> save(@RequestBody RepresentantLegalTitre representantLegalTitre) {		
	      RepresentantLegalTitre resRepresentantLegalTitre=representantLegalTitreService.save(representantLegalTitre);
	      //RepresentantLegalTitre RepresentantLegalTitre=RepresentantLegalTitreService.save(RepresentantLegalTitre);
	      return new ResponseEntity<>(resRepresentantLegalTitre,HttpStatus.CREATED);
	    }
	    
	    @GetMapping(path = "findRepresentantLegalTitre/{ref}")
	    public RepresentantLegalTitre getRepresentantLegalTitreByRef(@PathVariable(name = "ref") Integer ref){
	      System.out.println("ref" +ref);
	      RepresentantLegalTitre RepresentantLegalTitre = representantLegalTitreService.getRepresentantLegalTitreById(ref);
	      return RepresentantLegalTitre; 
	    }
	    
	    
	    
	    @DeleteMapping(path = "deleteRepresentantLegalTitre/{id}") 
	    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {		
	      
	  
	      return representantLegalTitreService.delete(id);	
	    }
	  
	     @PutMapping("/updateRepresentantLegalTitre/{id}")
	        public ResponseEntity<RepresentantLegalTitre> updateRepresentantLegalTitre(@RequestBody RepresentantLegalTitre representantLegalTitre,@PathVariable(name = "id") Integer id) {
	       RepresentantLegalTitre resRepresentantLegalTitre = representantLegalTitreService.update(representantLegalTitre,id);
	            return new ResponseEntity<>(resRepresentantLegalTitre, HttpStatus.OK);
	        }
}
