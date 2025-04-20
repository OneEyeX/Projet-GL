package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xtensus.passosyf.entities.AppelOffres;

public interface AppelOffresService {

	public List<AppelOffres> getAllAppelOffres();

	public AppelOffres getAppelOffresById(int id);

	public AppelOffres saveAppelOffres(AppelOffres appelOffres);

	public void deleteAppelOffres(AppelOffres appelOffres);

	public void deleteAppelOffresById(int id);

	public Page<AppelOffres> getAllAppelOffres(int pageNum, int pageSize, String sortField, String sortDir);

	public Page<AppelOffres> searchAppelOffres(String search, int pageNum, int pageSize, String sortField,
			String sortDir);

	public void setEtat(AppelOffres appelOffres, int etatId);

	public void addCommissionToAppelOffres(int commissionId, int appelOffreId);
}
