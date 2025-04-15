package com.xtensus.passosyf.controllers;

import java.io.FileNotFoundException;
import java.util.List;


//import org.aspectj.apache.bcel.classfile.Module.Export;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xtensus.passosyf.entities.Soumissionnaire;
//import com.xtensus.passosyf.services.SocieteService;
import com.xtensus.passosyf.services.SoumissionnaireService;

import net.sf.jasperreports.engine.JRException;
//import com.xtensus.passosyf.servicesImp.Export;


@ResponseBody
@Controller
@RequestMapping(path = "Soumissionnaire")
@CrossOrigin(origins = "*")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class SoumissionnaireController {
	@Autowired
	SoumissionnaireService soumissionnaireService;
	
//	@Autowired
//	private Export export;

	
//	@Autowired
//	private AppelOffresService appelOffresService;
	
	
	@GetMapping(value = "allSoumissionnaires")
	public List<Soumissionnaire> getAll() {
		return soumissionnaireService.getAll();
	}
	
	
	
	
	@GetMapping(value = "/getAllSoumissionnaires/{pageNum}/{pageSize}")
	public Page<Soumissionnaire> getAllSoumissionnaires(@PathVariable("pageNum") int pageNum,
			                                            @PathVariable("pageSize") int pageSize,
			                                            @Param("sortDir") String sortDir, 
			                                            @Param("sortField") String sortField, 
			                                            @Param("search") String search) {
		//System.out.println("aaaaaaaaaaaaa"+search+"hhhhhhh");
		return soumissionnaireService.findAll(pageNum, pageSize, sortDir, sortField,search);
	}
	
	@GetMapping("/getPdfList")
	public ResponseEntity<byte[]> exportListeSoumissionnaires() throws FileNotFoundException, JRException {
		
		byte[] pdfBytes = soumissionnaireService.exportListeSoumissionnaires();
		
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "list.pdf");

        // Return the response entity with the PDF bytes and headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
	}

	@DeleteMapping(value = "/supp/{id}")
	public List<Soumissionnaire> supp(@PathVariable int id) {
		return soumissionnaireService.supprimer(id);
	}

	@PostMapping("/ajouter")
	public List<Soumissionnaire> ajouter(@RequestBody Soumissionnaire t) {
		return soumissionnaireService.ajouter(t);

	}

	@PutMapping("update")
	public void update(@RequestBody Soumissionnaire t1) {
		soumissionnaireService.update(t1);

	}

	@GetMapping(value = "getone/{id}")
	public Soumissionnaire getone(@PathVariable int id) {
		return soumissionnaireService.getone(id);
	}
	
	@GetMapping(value = "findSoumissionnaireByMatricule/{matricule}")
	public Soumissionnaire findSoumissionnaireByMatricule(@PathVariable String matricule) {
	 
		return soumissionnaireService.findSoumissionnaireByMatricule(matricule.replace("*", "/"));
	}
	@GetMapping(value="/activer/{soumissionnaireReference}")
	public Soumissionnaire activerCompte(@PathVariable (name = "soumissionnaireReference") int soumissionnaireReference) {
		return soumissionnaireService.changeEtatCompte(soumissionnaireReference, 69);
	}
	
	
	@GetMapping(value="/desactiver/{soumissionnaireReference}")
	public Soumissionnaire desactiverCompte(@PathVariable (name = "soumissionnaireReference") int soumissionnaireReference) {
		return soumissionnaireService.changeEtatCompte(soumissionnaireReference, 71);
	}
	
	@GetMapping(value = "/soumissionnaireByAppelOffre/{appelOffreReference}/{pageNum}/{pageSize}")
	public Page <Soumissionnaire> soumissionnaireByAppelOffre(@PathVariable (name = "appelOffreReference") int appelOffreReference,
			                                                  @PathVariable("pageNum") int pageNum,
			                                                  @PathVariable("pageSize") int pageSize,
			                                                  @Param("sortDir") String sortDir, 
			                                                  @Param("sortField") String sortField, 
			                                                  @Param("search") String search) {
		System.out.println("Les Params : ///////" + pageNum + " / " + pageSize + " / " + sortDir + " / " + sortField + " / " + search);
		return soumissionnaireService.soumissionnaireByAppelOffreReference(appelOffreReference,pageNum, pageSize, sortDir, sortField,search);
	}
	
//	
//	AppelOffreSoumissionnaireModel remplirAppelOffreSoumissionnaire(List<Soumissionnaire> soumissionnaire,AppelOffre appelOffre) {
//		AppelOffreSoumissionnaireModel appelOffreSoumissionnaireModel=new AppelOffreSoumissionnaireModel();
//		
//		
//		appelOffreSoumissionnaireModel.setSocieteNom(societeService.getSocieteByLibelle("Ministere_Nom").getSocieteLibelle());
//		appelOffreSoumissionnaireModel.setSocieteOrganismeParent(societeService.getSocieteByLibelle("Nom_Societe").getSocieteLibelle());
//		appelOffreSoumissionnaireModel.setSocieteRepublique(societeService.getSocieteByLibelle("Republique_Nom").getSocieteLibelle());
//		appelOffreSoumissionnaireModel.setSocieteVille(societeService.getSocieteByLibelle("Ville_Nom").getSocieteLibelle());
//		
//		
//		Date date = new Date();
//		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
//		String stringDate= DateFor.format(date);
//		
//		appelOffreSoumissionnaireModel.setDateCreation(stringDate);
//		
//		appelOffreSoumissionnaireModel.setAppelOffreReference(appelOffre.getAppelOffreReference());
//		appelOffreSoumissionnaireModel.setAppelOffreIntitule(appelOffre.getAppelOffreIntitule());
//		appelOffreSoumissionnaireModel.setAppelOffreObjet(appelOffre.getAppelOffreObjet());
//		appelOffreSoumissionnaireModel.setAppelOffreCode(appelOffre.getAppelOffreCode());
//		
//		String stringDatePublication= DateFor.format(appelOffre.getAppelOffreDatePublication());
//		appelOffreSoumissionnaireModel.setAppelOffreDatePublication(stringDatePublication);
//		if(appelOffre.getNature() != null) {
//			appelOffreSoumissionnaireModel.setNature(appelOffre.getNature().getNatureLibelle());
//		}
//		
//		
//		if(appelOffre.getModereglement() != null) {
//			appelOffreSoumissionnaireModel.setModereglement(appelOffre.getModereglement().getModeReglementLibelle());
//		}
//		appelOffreSoumissionnaireModel.setListAppelOffreSoumissionnaireModels(soumissionnaire);
//		
////		appelOffreSoumissionnaireModel.setSoumissionnaireReference(soumissionnaire.getSoumissionnaireReference());
////		appelOffreSoumissionnaireModel.setSoumissionnaireRaisonSociale(soumissionnaire.getSoumissionnaireRaisonSociale());
////		appelOffreSoumissionnaireModel.setSoumissionnaireAdresseSiegeSocial(soumissionnaire.getSoumissionnaireAdresseSiegeSocial());
////		appelOffreSoumissionnaireModel.setSoumissionnaireAnneeCreation(soumissionnaire.getSoumissionnaireAnneeCreation());
//		
//		return appelOffreSoumissionnaireModel;
//	}
	
//	@GetMapping("/export/{appelOffreRef}")
//	public ResponseEntity<byte[]> export(HttpServletResponse response,@PathVariable(name="appelOffreRef") int appelOffreRef) {
//		
//		
//		List<Soumissionnaire> soumissionnaires=soumissionnaireService.soumissionnaireByAppelOffreReference(appelOffreRef);
//		String nomTemplate="Soumissionnair.jrxml";
//		
//		AppelOffres appelOffre=appelOffresService.getAppelOffresById(appelOffreRef);
//		
//		List<AppelOffreSoumissionnaireModel> appelOffreSoumissionnaireModels=new ArrayList<AppelOffreSoumissionnaireModel>();
//		
//		AppelOffreSoumissionnaireModel appelOffreSoumissionnaireModel=remplirAppelOffreSoumissionnaire(soumissionnaires,appelOffre);
//
//		
//		appelOffreSoumissionnaireModels.add(appelOffreSoumissionnaireModel);
//		return export.exportToPdf(response, appelOffreSoumissionnaireModels, nomTemplate);
//
//	}
	
	
	@GetMapping("/isUsedBySoumissionnaireId/{soumissionnaireId}")
	public Integer isUsedBySoumissionnaireId(@PathVariable(name="soumissionnaireId")Integer soumissionnaireId) {
		return soumissionnaireService.isUsedBySoumissionnaireId(soumissionnaireId);

	}
	
}
