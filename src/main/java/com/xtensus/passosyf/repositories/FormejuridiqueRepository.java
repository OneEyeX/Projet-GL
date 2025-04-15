package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Formejuridique;

public interface FormejuridiqueRepository extends JpaRepository<Formejuridique, Integer> {
	
	public List<Formejuridique> findByOrderByFormeJuridiqueIdDesc();


}
