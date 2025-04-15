package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Pays;


public interface PaysRepository extends JpaRepository<Pays, Integer >{
	public List<Pays> findByOrderByPaysIdDesc();
}
