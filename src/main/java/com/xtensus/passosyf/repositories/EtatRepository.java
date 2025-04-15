package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.entities.EtatCategorie;

public interface EtatRepository extends JpaRepository<Etat, Integer>{

	List<Etat> findAllByEtatCategorie(EtatCategorie etatCategorie);

}
