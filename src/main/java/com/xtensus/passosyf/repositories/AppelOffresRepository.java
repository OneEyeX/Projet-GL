package com.xtensus.passosyf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xtensus.passosyf.entities.AppelOffres;


public interface AppelOffresRepository extends JpaRepository<AppelOffres, Integer>  {

	@Query("SELECT appelOffres FROM AppelOffres appelOffres "
			+ "LEFT JOIN appelOffres.nature nature LEFT JOIN appelOffres.modeReglement modeReglement  "
			+ "WHERE appelOffres.appelOffreIntitule LIKE %:search% OR appelOffres.appelOffreCode LIKE %:search% OR appelOffres.appelOffreObjet LIKE %:search% OR appelOffres.nature.natureLibelle LIKE %:search% OR appelOffres.modeReglement.modeReglementLibelle LIKE %:search%")
	Page<AppelOffres> searchAppelOffres(@Param("search") String search, Pageable pageable);
}
