package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Formejuridique;

public interface FormejuridiqueService {

	public List<Formejuridique> getAllFormejuridiques();
	
	public Formejuridique getFormejuridiqueById(int id);

	public Formejuridique saveFormejuridique(Formejuridique formejuridique);

	public void deleteFormejuridique(Formejuridique formejuridique);

	public void deleteFormejuridiqueById(int id);
}
