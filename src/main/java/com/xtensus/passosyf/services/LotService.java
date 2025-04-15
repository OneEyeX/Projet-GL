package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.xtensus.passosyf.entities.Lot;


public interface LotService {

	
	public List<Lot> getAllLots();
	
	public Lot getLotById(int id);

	public Lot saveLot(Lot lot);

	public void deleteLot(Lot lot);

	public void deleteLotById(int id);
	
    public Page<Lot> getLotsByAppelOffreId(int appelOffreId , int pageNum, int pageSize, String sortField, String sortDir);

	public Page<Lot> searchLots(String search,int appelOffreId, int pageNum, int pageSize, String sortField, String sortDir);

	public List<Lot> getLotsByAppelOffreId(int appelOffreId);
}
