package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.xtensus.passosyf.entities.RepresentantLegalTitre;

public interface RepresentantLegalTitreService {
	
	public RepresentantLegalTitre save(RepresentantLegalTitre representantLegalTitre);
	
    public RepresentantLegalTitre update(RepresentantLegalTitre representantLegalTitre,Integer id);
    
    public ResponseEntity<?> delete(Integer id);
    
    public List<RepresentantLegalTitre> ListRepresentantLegalTitre();
    
    public RepresentantLegalTitre getRepresentantLegalTitreById(Integer id);
	
	
	
}
