package com.xtensus.passosyf.services;

import java.util.List;
import java.util.Set;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Pays;

public interface GouverneratService {
	
	public List<Gouvernerat> getAllGouvernerats();
	
	public Gouvernerat getGouverneratById(int id);

	public Gouvernerat saveGouvernerat(Gouvernerat gouvernerat);

	public void deleteGouvernerat(Gouvernerat gouvernerat);

	public void deleteGouverneratById(int id);

	public Set<Gouvernerat> getAllGouverneratsByPays(Pays pays);


}
