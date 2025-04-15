package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xtensus.passosyf.entities.Phase;

public interface PhaseService {

	public List<Phase> getAllPhases();
	
	public Phase getPhaseById(int id);

	public Phase savePhase(Phase phase);

	public void deletePhase(Phase phase);

	public void deletePhaseById(int id);
	
    public Page<Phase> getPhasesByLotId(int lotId , int pageNum, int pageSize, String sortField, String sortDir);

	public Page<Phase> searchPhases(String search,int lotId, int pageNum, int pageSize, String sortField, String sortDir);

	public List<Phase> getPhasesByLotId(int LotId);
}
