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

import com.xtensus.passosyf.entities.Lot;
import com.xtensus.passosyf.services.LotService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "Lot")
public class LotControlleur {

	@Autowired
	private LotService lotService;

	
	@GetMapping(value = "/getLots/{appelOffreId}", produces = "application/json")
	public Page<Lot> getLotsByAppelOffreId(@PathVariable int appelOffreId, 
                                @RequestParam(defaultValue = "0") int pageNum,
			                    @RequestParam(defaultValue = "10") int pageSize,
			                    @RequestParam(defaultValue = "lotReference") String sortField,
			                    @RequestParam(defaultValue = "asc") String sortDir,
			                    @RequestParam(required = false) String search) {
		Page<Lot> lotsPage;
		if (search != null && !search.isEmpty()) {
			lotsPage = lotService.searchLots(search, appelOffreId, pageNum, pageSize, sortField, sortDir);
		} else {
			lotsPage = lotService.getLotsByAppelOffreId(appelOffreId, pageNum, pageSize, sortField, sortDir);
		}

		return lotsPage;
	}
	

	@GetMapping(value = "/getLotById/{id}")
	public Lot getLotById(@PathVariable int id) {

		return lotService.getLotById(id);
	}

	@PostMapping(value = "/addLot")
	public void addLot(@RequestBody Lot lot) {

		lotService.saveLot(lot);

	}

	@DeleteMapping(value = "/deleteLotById/{id}")
	public void deleteLotById(@PathVariable int id) {

		lotService.deleteLotById(id);
	}

	@PutMapping(value = "/updateLot")
	public void updateLot(@RequestBody Lot lot) {

		lotService.saveLot(lot);
	}
}
