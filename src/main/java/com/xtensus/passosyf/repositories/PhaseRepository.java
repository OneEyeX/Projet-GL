package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xtensus.passosyf.entities.Phase;

public interface PhaseRepository extends JpaRepository<Phase, Integer> {


	
	@Query("SELECT phase FROM Phase phase "
			+ "INNER JOIN phase.lot lot "
			+ "WHERE ( phase.phaseLibelle LIKE %:search% OR phase.phaseObjet LIKE %:search% OR phase.phaseNumOrdre LIKE %:search% ) "
			+ "AND phase.lot.lotReference = :lotReference")
	Page<Phase> searchPhases(@Param("search") String search,@Param("lotReference") int lotReference, Pageable pageable);

	Page<Phase> findByLot_lotReference(int lotReference ,Pageable pageable);

	List<Phase> findByLot_lotReference(int lotReference);

}
