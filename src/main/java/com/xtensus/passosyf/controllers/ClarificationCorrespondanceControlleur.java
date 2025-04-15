package com.xtensus.passosyf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xtensus.passosyf.entities.ClarificationCorrespondance;
import com.xtensus.passosyf.services.ClarificationCorrespondanceService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "ClarificationCorrespondance")
public class ClarificationCorrespondanceControlleur {
	
	@Autowired
	private ClarificationCorrespondanceService clarificationCorrespondanceService;
	
	@GetMapping(value="/getClarificationCorrespondances/{appelOffreId}",  produces = "application/json")
	public Page <ClarificationCorrespondance> getClarificationCorrespondancesByAppelOffres(@PathVariable int appelOffreId,
												                @RequestParam String type,
												                @RequestParam(defaultValue = "0") int pageNum,
												                @RequestParam(defaultValue = "10") int pageSize,
												                @RequestParam(defaultValue = "correspondanceclarificationId") String sortField ,
												                @RequestParam(defaultValue = "asc") String sortDir ,
												                @RequestParam(required = false) String search){
		
	    Page<ClarificationCorrespondance> clarificationCorrespondancePage;
	    if (search != null && !search.isEmpty()) {
	    	
	        clarificationCorrespondancePage = clarificationCorrespondanceService.searchClarificationCorrespondances(
	                appelOffreId,
	                type,
	                search,
	                pageNum,
	                pageSize,
	                sortField,
	                sortDir
	        );
	    } else {
	    	
	    	clarificationCorrespondancePage = clarificationCorrespondanceService.getAllClarificationCorrespondancesByType(appelOffreId, type ,pageNum, pageSize, sortField, sortDir);
	    }

        return clarificationCorrespondancePage;
	}
	
	@PostMapping(value="/addClarificationCorrespondance")
	public void addClarificationCorrespondance(@RequestBody ClarificationCorrespondance clarificationCorrespondance){
		
		clarificationCorrespondanceService.saveClarificationCorrespondance(clarificationCorrespondance);

	}
}
