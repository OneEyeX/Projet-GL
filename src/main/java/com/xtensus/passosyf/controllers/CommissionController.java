package com.xtensus.passosyf.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xtensus.passosyf.entities.Commission;
//import com.xtensus.passosyf.entities.Document;
//import com.xtensus.passosyf.entities.MembreCellulePassation;
//import com.xtensus.passosyf.entities.MembreCommissionMarche;
//import com.xtensus.passosyf.gnl.aop.LogClass;
import com.xtensus.passosyf.services.CommissionService;
//import com.xtensus.passosyf.services.DocumentService;
//import com.xtensus.passosyf.servicesImp.CmisService;
//import com.xtensus.passosyf.utils.CommissionAffectationMembreModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/commissions")
public class CommissionController {

	private CommissionService commissionService;

	//@Autowired
	public CommissionController(CommissionService commissionService) {
		this.commissionService = commissionService;
	}

	//@Autowired
	//private LogClass logClass;

	//@Autowired
	//private DocumentService documentService;

	//@Autowired
	//private CmisService cmisService;

	//@Autowired
	//private DocumentController documentController;

	@GetMapping(path = "all")
	public ResponseEntity<List<Commission>> getAllCommission() {

		List<Commission> commissions = commissionService.listCommission();
		return new ResponseEntity<>(commissions, HttpStatus.OK);
	}

	
	
	@GetMapping(path = "allCommissionActive")
	public ResponseEntity<List<Commission>> getAllCommissionActive() {

		List<Commission> commissions = commissionService.listCommissionActive();
		return new ResponseEntity<>(commissions, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "allCommissionActiveAvecMembre/{reunionId}")
	public ResponseEntity<List<Commission>> getAllCommissionActiveAvecMembre(@PathVariable(name = "reunionId") int reunionId) {

		List<Commission> commissions = commissionService.getAllCommissionActiveAvecMembre(reunionId);
		return new ResponseEntity<>(commissions, HttpStatus.OK);
	}
	
	
	
	@PostMapping(path = "add")
	public ResponseEntity<Commission> save(
			@RequestPart(name = "fileDateEffet", required = false) MultipartFile fileDateEffet,
			@RequestPart(name = "fileDateFin", required = false) MultipartFile fileDateFin,
			@RequestPart(name = "commission") Commission commission) {
		Commission com;
		try {

			com = commissionService.save(commission, fileDateEffet, fileDateFin);

			return new ResponseEntity<>(com, HttpStatus.CREATED);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	}



	@GetMapping(path = "find/{id}")
	public ResponseEntity<Commission> commissionById(@PathVariable(name = "id") int id) {

		Commission commmi = commissionService.getCommissionById(id);


		return new ResponseEntity<>(commmi, HttpStatus.CREATED);

	}

	@DeleteMapping(path = "deleteMembre/{id}")
	public void delete(@PathVariable(name = "id") Integer id) {
		System.out.println("dans méthode delete  " + id);
	

		commissionService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCommission(
			@RequestPart(name = "fileDateEffet", required = false) MultipartFile fileDateEffet,
			@RequestPart(name = "fileDateFin", required = false) MultipartFile fileDateFin,
			@RequestPart(name = "commission") Commission commission, @PathVariable(name = "id") int id)
			throws IOException {
		Commission updateCommission = commissionService.update(commission, id, fileDateEffet, fileDateFin);


		return new ResponseEntity<>(updateCommission, HttpStatus.OK);
	}

	@PutMapping(path = "updateCommission/{id}")
	public ResponseEntity<?> updateCommissionById(@RequestBody Commission commission,
			@PathVariable(name = "id") int id) {

		Commission updateCommission = commissionService.updateCommission(commission, id);


		return new ResponseEntity<>(updateCommission, HttpStatus.OK);
	}




	@PostMapping(path = "desaffectationMembreCM/{membresCMId}/{commissionId}")
	public void desaffectationMembreCommissionMarche(@PathVariable(name = "membresCMId") int membresCMId,
			@PathVariable(name = "commissionId") int commissionId) {

		commissionService.desaffectationMembreCommissionMarche(membresCMId, commissionId);

	}

	@GetMapping(path = "desaffectationMembreCP/{membresCPId}/{commissionId}")
	public void desaffectationMembreCellulePassation(@PathVariable(name = "membresCPId") int membresCPId,
			@PathVariable(name = "commissionId") int commissionId) {
		// if CP ==> Supp membreCellulePasation

		commissionService.desaffectationMembreCellulePassation(membresCPId, commissionId);

	}

	@GetMapping(path = "commissionByIdentifiant/{commissionIdentifiant}")
	public ResponseEntity<Commission> getCommissionByIdentifiant(
			@PathVariable(name = "commissionIdentifiant") String commissionIdentifiant) {
		try {
			System.out.println("commissionIdentifiant "+commissionIdentifiant);
			Commission commissionIdenti = commissionService .getCommissionByIdentifiant(commissionIdentifiant);
//			System.out.println("commissionIdenti ===> "+ commissionIdenti.getCommissionIdentifiant());
			return new ResponseEntity<>(commissionIdenti, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}




	@GetMapping(path = "CommissionByType/{idType}")
	public ResponseEntity<List<Commission>> getCommissionsByType(@PathVariable(name = "idType") int idType) {
		List<Commission> comm = commissionService.findByCommissionTypeCommissionTypeReference(idType);
		if (comm != null && comm.size() > 0)
			return new ResponseEntity<>(comm, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
