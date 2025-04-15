package com.xtensus.passosyf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.xtensus.passosyf.entities.Devise;

public interface DeviseRepository extends JpaRepository<Devise, Integer> , PagingAndSortingRepository<Devise, Integer> {

	Page<Devise> findByDeviseIdentifiantContainingOrDeviseNomContainingOrDeviseNomDecimaleContaining(String search1,
			String search2, String search3, Pageable pageable);
	
	@Query("SELECT devise FROM Devise devise "
			+ "WHERE devise.deviseIdentifiant LIKE %:search% OR devise.deviseNom LIKE %:search% OR devise.deviseNomDecimale LIKE %:search%")
	Page<Devise> searchDevises(@Param("search") String search, Pageable pageable);
	

}
