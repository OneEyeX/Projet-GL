package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.SecteurActivite;

public interface SecteurActiviteService {

	public List<SecteurActivite> getAllSecteurActivites();
	
	public SecteurActivite getSecteurActiviteById(int id);

	public SecteurActivite saveSecteurActivite(SecteurActivite secteurActivite);

	public void deleteSecteurActivite(SecteurActivite secteurActivite);

	public void deleteSecteurActiviteById(int id);
}
