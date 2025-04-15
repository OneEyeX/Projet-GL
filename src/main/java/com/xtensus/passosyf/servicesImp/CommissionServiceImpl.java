package com.xtensus.passosyf.servicesImp;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xtensus.passosyf.entities.Commission;
import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.repositories.CommissionRepository;
import com.xtensus.passosyf.repositories.EtatRepository;
import com.xtensus.passosyf.services.CommissionService;


@Service
@Transactional
public class CommissionServiceImpl implements CommissionService {

	// Repository
	@Autowired
	private CommissionRepository commissionRepository;
	private EtatRepository etatRepository;



	@Override
	public Commission save(Commission commission, MultipartFile fileDateEffet, MultipartFile fileDateFin)
			throws IOException {
		// Etat
		Optional<Etat> etat = etatRepository.findById(51);
		System.out.println("affiche etat =================> " + etat);
		commission.setEtat(etat.get());

		// set Document
 
		Commission savedCommission = commissionRepository.save(commission);

		if (fileDateEffet != null) {
			System.out.println("fileDateEffet.isEmpty()");
			//saveDocument(savedCommission, fileDateEffet, 1);
		}
		if (fileDateFin != null) {
			System.out.println("fileDateFin.isEmpty()");
			//saveDocument(savedCommission, fileDateFin, 0);
		}
		return savedCommission;
	}

	@Override
	public Commission update(Commission commission, int id, MultipartFile fileDateEffet, MultipartFile fileDateFin)
			throws IOException {

		Commission savedCommission = commissionRepository.findById(id).get(); 
		savedCommission.setCommissionIntitule(commission.getCommissionIntitule());
		savedCommission.setCommissionIdentifiant(commission.getCommissionIdentifiant());
		savedCommission.setDateEffetCommission(commission.getDateEffetCommission());
		savedCommission.setDateFinCommission(commission.getDateFinCommission());
		savedCommission.setCommissionObjet(commission.getCommissionObjet());
		//savedCommission.setCommissionType(commission.getCommissionType());

		//commissionRepository.updateDateFinAffectationMembrCommissionMarche(id,commission.getDateFinCommission());
		//commissionRepository.updateDateFinAffectationMembreCellulePassation(id,commission.getDateFinCommission());

		return  commissionRepository.save(savedCommission);

 
	}


	@Override
	public void delete(Integer id) {
		commissionRepository.deleteById(id);
	}

	@Override
	public List<Commission> listCommission() {
		return commissionRepository.findAll(Sort.by(Sort.Direction.DESC,"dateEffetCommission"));
	}

	@Override
	public Commission getCommissionById(Integer id) {

		return commissionRepository.findById(id).get();
	}

	public Date calculDateFin(Date dateDebut) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateDebut);
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date dateAffecttation = cal.getTime();

		return dateAffecttation;

	}

	

	public void desaffectationMembreCellulePassation(int membresCPId, int commissionId) {
		// if CP ==> Supp membreCellulePasation
		//membreCellulePassationRepository.deleteById(membresCPId);

		Commission commission = commissionRepository.findById(commissionId).get();
		commission.setCommissionNbrMembres(commission.getCommissionNbrMembres() - 1);
		commissionRepository.save(commission);

	}

	@Override
	public Commission getCommissionByIdentifiant(String Identifiant) {
		
		System.out.println("Identifiant "+Identifiant);
 
		Commission commissionByIdenti = commissionRepository.findByCommissionIdentifiant( Identifiant.replace("*", "/"));
		return commissionByIdenti;

	}




	@Override
	public Commission updateCommission(Commission commission,int id) {
		
		commission.setCommissionReference(id);
		Commission savedCommission = commissionRepository.save(commission);
		return savedCommission;
	}

	@Override
	public void desaffectationMembreCommissionMarche(int membresCMId, int commissionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commission> listCommissionActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commission> getAllCommissionActiveAvecMembre(int reunionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commission getLastCommission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commission> findByCommissionTypeCommissionTypeReference(int typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public List<Commission> listCommissionActive() {
		// TODO Auto-generated method stub
 	//	return commissionRepository.getAllCommissionActive(); 
	//}
	
	
	

}
