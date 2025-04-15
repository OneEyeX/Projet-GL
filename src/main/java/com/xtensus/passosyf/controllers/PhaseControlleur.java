package com.xtensus.passosyf.controllers;

import java.util.List;

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

import com.xtensus.passosyf.entities.Phase;
import com.xtensus.passosyf.services.PhaseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Phase")
public class PhaseControlleur {

	@Autowired
	private PhaseService phaseService;

	
	@GetMapping(value = "/getPhases/{lotId}", produces = "application/json")
	public Page<Phase> getPhasesByLotId(@PathVariable int lotId,
			                            @RequestParam(defaultValue = "0") int pageNum,
			                            @RequestParam(defaultValue = "10") int pageSize,
			                            @RequestParam(defaultValue = "phaseReference") String sortField,
			                            @RequestParam(defaultValue = "asc") String sortDir, 
			                            @RequestParam(required = false) String search) {
		Page<Phase> phasesPage;
		if (search != null && !search.isEmpty()) {
			phasesPage = phaseService.searchPhases(search, lotId, pageNum, pageSize, sortField, sortDir);
		} else {
			phasesPage = phaseService.getPhasesByLotId(lotId, pageNum, pageSize, sortField, sortDir);
		}

		return phasesPage;
	}

	@GetMapping(value="/getPhasesByLotId/{lotId}")
	public List<Phase> getPhasesByLotId(@PathVariable int lotId){
		
		return phaseService.getPhasesByLotId(lotId);
		
	}


	@PostMapping(value = "/addPhase")
	public void addPhase(@RequestBody Phase phase) {

		phaseService.savePhase(phase);

	}

	@DeleteMapping(value = "/deletePhaseById/{id}")
	public void deletePhaseById(@PathVariable int id) {

		phaseService.deletePhaseById(id);
	}

	@PutMapping(value = "/updatePhase")
	public void updatePhase(@RequestBody Phase phase) {

		phaseService.savePhase(phase);
	}
}
