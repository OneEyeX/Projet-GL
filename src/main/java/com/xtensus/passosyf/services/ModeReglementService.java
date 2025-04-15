package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.ModeReglement;

public interface ModeReglementService {

	public List<ModeReglement> getAllModeReglements();
	
	public ModeReglement getModeReglementById(int id);

	public ModeReglement saveModeReglement(ModeReglement modeReglement);

	public void deleteModeReglement(ModeReglement modeReglement);

	public void deleteModeReglementById(int id);
}
