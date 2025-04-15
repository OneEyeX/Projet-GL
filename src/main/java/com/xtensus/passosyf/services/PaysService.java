package com.xtensus.passosyf.services;

import java.util.List;
import com.xtensus.passosyf.entities.Pays;

public interface PaysService {
	
	public List<Pays> getAllPays();
	
	public Pays getPaysById(int id);
	
	public Pays savePays(Pays pays);
	
	public void deletePaysById(int id);
	
	public void deletePays(Pays pays);

}
