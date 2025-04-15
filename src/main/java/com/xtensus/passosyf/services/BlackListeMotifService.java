package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.BlackListeMotif;

public interface BlackListeMotifService {

	public List<BlackListeMotif> getAllBlackListeMotifs();
	
	public BlackListeMotif getBlackListeMotifById(int id);

	public BlackListeMotif saveBlackListeMotif(BlackListeMotif blackListeMotif);

	public void deleteBlackListeMotif(BlackListeMotif blackListeMotif);

	public void deleteBlackListeMotifById(int id);
}
