package com.xtensus.passosyf.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.Commission;
import com.xtensus.passosyf.services.AppelOffresService;
import com.xtensus.passosyf.services.CommissionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "AppelOffres")
public class AppelOffresControlleur {

	@Autowired
	private AppelOffresService appelOffresService;
	
    @Autowired
    private CommissionService commissionService;
	
	
	@GetMapping(value="/getAppelOffres",  produces = "application/json")
	public Page <AppelOffres> getAllAppelOffres( @RequestParam(defaultValue = "0") int pageNum,
                                                 @RequestParam(defaultValue = "10") int pageSize,
                                                 @RequestParam(defaultValue = "appelOffreId") String sortField ,
                                                 @RequestParam(defaultValue = "asc") String sortDir ,
                                                 @RequestParam(required = false) String search){
	    Page<AppelOffres> appelOffresPage;
	    if (search != null && !search.isEmpty()) {
	        appelOffresPage = appelOffresService.searchAppelOffres(search, pageNum, pageSize, sortField, sortDir);
	    } else {
	        appelOffresPage = appelOffresService.getAllAppelOffres(pageNum, pageSize, sortField, sortDir);
	    }

        return appelOffresPage;
	}
	
	
	
	
	@GetMapping(value="/getAppelOffresById/{id}")
	public AppelOffres getAppelOffresById(@PathVariable int id) {

		return appelOffresService.getAppelOffresById(id);
	}
	
	@PostMapping(value="/addAppelOffres")
	public void addAppelOffres(@RequestBody AppelOffres appelOffres){
		
		appelOffresService.saveAppelOffres(appelOffres);

	}
	
	@PostMapping(value="/addCommissionToAppelOffres/{commissionId}/{appelOffreId}")
	public ResponseEntity<?> addCommissionToAppelOffres(@PathVariable int commissionId,@PathVariable int appelOffreId){
		
        
        AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
        if (appelOffres == null) {
            return ResponseEntity.notFound().build();
        }
        
        Commission commission = commissionService.getCommissionById(commissionId);
        if (commission == null) {
            return ResponseEntity.notFound().build();
        }
        
        
        appelOffres.getCommissions().add(commission);
        commission.getAppelOffres().add(appelOffres);
        
        
        appelOffresService.saveAppelOffres(appelOffres);
        
        return ResponseEntity.ok().build();
    

	}
	
	//@PostMapping(value="/addAppelOffres/{etatId}")
	//public void addAppelOffres(@RequestBody AppelOffres appelOffres, @PathVariable int etatId){
		
	//	appelOffresService.setEtat(appelOffres,etatId);
	//	appelOffresService.saveAppelOffres(appelOffres);

	//}
	
	@DeleteMapping(value="/deleteAppelOffresById/{id}")
	public void deleteAppelOffresById(@PathVariable int id) {
		

		appelOffresService.deleteAppelOffresById(id);
	}
	
	@PutMapping(value="/updateAppelOffres")
	public void updateAppelOffres(@RequestBody AppelOffres appelOffres) {
		
		appelOffresService.saveAppelOffres(appelOffres);
	}
	
	@PutMapping(value="/setEtat/{appelOffreId}/{etatId}")
	public void setEtat(@PathVariable int  appelOffreId , @PathVariable int etatId) {
		
		 AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
		 appelOffresService.setEtat(appelOffres,etatId);
		 appelOffresService.saveAppelOffres(appelOffres);

	}
	
}
