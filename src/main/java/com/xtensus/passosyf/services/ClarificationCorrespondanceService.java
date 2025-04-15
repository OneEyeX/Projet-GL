package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xtensus.passosyf.entities.ClarificationCorrespondance;

public interface ClarificationCorrespondanceService {
	
	public List<ClarificationCorrespondance> getAllClarificationCorrespondances();
	
	public ClarificationCorrespondance getClarificationCorrespondanceById(int id);

	public ClarificationCorrespondance saveClarificationCorrespondance(ClarificationCorrespondance clarificationCorrespondance);

	public void deleteClarificationCorrespondanceById(int id);
	
    public Page<ClarificationCorrespondance> getAllClarificationCorrespondancesByType(int appelOffreId, String correspondanceclrType , int pageNum, int pageSize, String sortField, String sortDir);

	public Page<ClarificationCorrespondance> searchClarificationCorrespondances(int appelOffreId, String correspondanceclrType, String search, int pageNum, int pageSize, String sortField, String sortDir);


}
