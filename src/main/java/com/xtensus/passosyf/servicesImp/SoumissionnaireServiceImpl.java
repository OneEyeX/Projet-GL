package com.xtensus.passosyf.servicesImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.entities.Soumissionnaire;
import com.xtensus.passosyf.factories.EtatFactory;
import com.xtensus.passosyf.repositories.EtatRepository;
import com.xtensus.passosyf.repositories.FonctionRepository;
import com.xtensus.passosyf.repositories.FormejuridiqueRepository;
import com.xtensus.passosyf.repositories.GouverneratRepository;
import com.xtensus.passosyf.repositories.PaysRepository;
import com.xtensus.passosyf.repositories.SoumissionnaireRepository;
import com.xtensus.passosyf.repositories.TypeMarcheRepository;
import com.xtensus.passosyf.repositories.VilleRepository;
import com.xtensus.passosyf.services.SoumissionnaireService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class SoumissionnaireServiceImpl implements SoumissionnaireService {
	@Autowired
	SoumissionnaireRepository repo;
	@Autowired
	FonctionRepository repofonction;
	@Autowired
	FormejuridiqueRepository repoforme;
	@Autowired
	TypeMarcheRepository repoTypeMarche;
	@Autowired
	GouverneratRepository repoGouvernerat;
	@Autowired
	VilleRepository repoVille;
	@Autowired
	PaysRepository repoPays;
	@Autowired
	EtatRepository repoEtat;
	
	@Autowired
    private Map<String, ExportStrategy> exportStrategies; 
	
	@Autowired
	private EtatFactory etatFactory;

	
	
	
	
	
	@Override
	public List<Soumissionnaire> ajouter(Soumissionnaire t) {
		repo.save(t);
		return repo.findByOrderBySoumissionnaireReferenceDesc();
	}

	
	public Soumissionnaire save(Soumissionnaire soumissionnaire) {
		
		return repo.save(soumissionnaire);
	} 
	public List<Soumissionnaire> getAll() {
		return repo.findByOrderBySoumissionnaireReferenceDesc();
	}
	
	
	public Page<Soumissionnaire> findAll(int pageNum,int pageSize, String sortDir, String sortField,String search){
			// TODO Auto-generated method stub

			    if(sortField==null || sortField==""){
			        sortField="soumissionnaireRaisonSociale";
			    }
			    if(sortDir==null || sortDir==""){
			        sortDir="desc";
			    }
			    Sort sort=Sort.by(sortField);
			    sort=sortDir.equals("asc")?sort.ascending(): sort.descending();

				Pageable pageable= PageRequest.of(pageNum,pageSize,sort); 
		return repo.findAllSoumissionnaire(search,pageable);
	}

	public List<Soumissionnaire> supprimer(int id) {
		repo.deleteById(id);
		return repo.findByOrderBySoumissionnaireReferenceDesc();
	}

	public Soumissionnaire getone(int id) {
		return repo.findById(id).get();
	}

	public void update(Soumissionnaire t1) {
		repo.save(t1);
	}
	
	public Soumissionnaire changeEtatCompte(int soumissionnaireReference ,int etatId) {
	    Soumissionnaire soumissionnaire = repo.findById(soumissionnaireReference).get();
	    Etat etat = etatFactory.createEtat(etatId); // 👍 usage du Creator
	    soumissionnaire.setSoumissionnaireEtatCompte(etat);
	    return repo.save(soumissionnaire);
	}
	
	public Page<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreSoumissionnaireReference,int pageNum,int pageSize, String sortDir, String sortField,String search){
		   if(sortField==null || sortField==""){
		        sortField="soumissionnaireRaisonSociale";
		    }
		    if(sortDir==null || sortDir==""){
		        sortDir="desc";
		    }
		    Sort sort=Sort.by(sortField);
		    sort=sortDir.equals("asc")?sort.ascending(): sort.descending();

			Pageable pageable= PageRequest.of(pageNum,pageSize,sort); 
		return repo.soumissionnaireByAppelOffreReference(appelOffreSoumissionnaireReference,search,pageable);
	}
	
	public List<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreReference){
		return repo.soumissionnaireByAppelOffreReference(appelOffreReference);
	}

	@Override
	public Soumissionnaire findSoumissionnaireByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return repo.findBySoumissionnaireMatriculeFiscal(matricule); 
	}
	
	
	@Override
	public Integer isUsedBySoumissionnaireId(Integer soumissionnaireId) {
		return repo.isUsedBySoumissionnaireId(soumissionnaireId);
	}

	@Override
    public byte[] exportListeSoumissionnaires(String format) throws FileNotFoundException, JRException {
        List<Soumissionnaire> soumissionnaires = repo.findAll();
        
        ExportStrategy strategy = exportStrategies.get(format.toLowerCase() + "ExportStrategy");
        if (strategy == null) {
            throw new IllegalArgumentException("Format non supporté: " + format);
        }
        
        return strategy.exporter(soumissionnaires);
    }
	
}
