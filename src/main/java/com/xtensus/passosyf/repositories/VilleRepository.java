package com.xtensus.passosyf.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

	Set<Ville> findAllByGouvernerat(Gouvernerat gouvernerat);

}
