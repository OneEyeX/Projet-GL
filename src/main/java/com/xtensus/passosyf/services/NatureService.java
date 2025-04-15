package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Nature;

public interface NatureService {
	
	
	public List<Nature> getAllNatures();
	
	public Nature getNatureById(int id);

	public Nature saveNature(Nature nature);

	public void deleteNature(Nature nature);

	public void deleteNatureById(int id);


}
