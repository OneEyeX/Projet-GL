package com.xtensus.passosyf.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.xtensus.passosyf.entities.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Integer> {
	

	Commission findByCommissionIdentifiant(String replace);



}
