package com.xtensus.passosyf.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Pays;

public interface GouverneratRepository extends JpaRepository<Gouvernerat, Integer> {

	Set<Gouvernerat> findAllByPays(Pays pays);

}
