package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.SoumissionnaireBlackList;

public interface SoumissionnaireBlackListService {

	public List<SoumissionnaireBlackList> getAllSoumissionnaireBlackLists();
	
	public SoumissionnaireBlackList getSoumissionnaireBlackListById(int id);

	public SoumissionnaireBlackList saveSoumissionnaireBlackList(SoumissionnaireBlackList motif);

	public void deleteSoumissionnaireBlackList(SoumissionnaireBlackList motif);

	public void deleteSoumissionnaireBlackListById(int id);
}
