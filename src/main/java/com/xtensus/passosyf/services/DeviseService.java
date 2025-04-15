package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xtensus.passosyf.entities.Devise;

public interface DeviseService {

	public List<Devise> getAllDevises();
	
	public Devise getDeviseById(int id);

	public Devise saveDevise(Devise devise);

	public void deleteDevise(Devise devise);

	public void deleteDeviseById(int id);
	
    public Page<Devise> getAllDevises(int pageNum, int pageSize, String sortField, String sortDir);

	public Page<Devise> searchDevises(String search, int pageNum, int pageSize, String sortField, String sortDir);
}
