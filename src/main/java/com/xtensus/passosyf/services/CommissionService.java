package com.xtensus.passosyf.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xtensus.passosyf.entities.Commission;


public interface CommissionService {
	
	public Commission save(Commission commission,MultipartFile fileDateEffet,MultipartFile fileDateFin  ) throws IOException;
	public Commission update(Commission commission,int id, MultipartFile fileDateEffet,MultipartFile fileDateFin) throws IOException; 
	public void delete(Integer id);
	public List<Commission> listCommission();
	public Commission getCommissionById(Integer id);
	public void desaffectationMembreCommissionMarche(int membresCMId, int commissionId);
	public void desaffectationMembreCellulePassation(int membresCPId, int commissionId);
	public Commission getCommissionByIdentifiant(String Identifiant);

	
	public Commission getLastCommission();
	
	public List<Commission> findByCommissionTypeCommissionTypeReference(int typeId);
	public Commission updateCommission(Commission commission,int id);
	
	
	public List<Commission> listCommissionActive( ) ; 
	
	public List<Commission> getAllCommissionActiveAvecMembre(int reunionId) ; 
	
}
