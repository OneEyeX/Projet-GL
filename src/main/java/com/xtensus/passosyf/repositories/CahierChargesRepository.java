package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.CahierCharges;

public interface CahierChargesRepository extends JpaRepository<CahierCharges, Integer> {

	List<CahierCharges> findByAppelOffre(AppelOffres appelOffre);

	CahierCharges findByAppelOffre_AppelOffreId(int aoId);

}
