package com.xtensus.passosyf.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.EtatCategorie;

public interface EtatCategorieRepository extends JpaRepository<EtatCategorie, Integer> {

	Optional<EtatCategorie> findByEtatCategorieLibelle(String etatCategorielibelle);

}
