package com.xtensus.passosyf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xtensus.passosyf.entities.ClarificationCorrespondance;
 


public interface ClarificationCorrespondanceRepository extends JpaRepository<ClarificationCorrespondance, Integer> {
	
	
	@Query("SELECT c FROM ClarificationCorrespondance c "
			+ "INNER JOIN c.appelOffres appelOffre "
			+ "WHERE c.correspondanceclrType = :type AND c.appelOffres.appelOffreId = :appelOffreId "
			+ "AND (c.correspondanceclrObjet LIKE %:search% OR c.correspondanceclrDescription LIKE %:search%)")
	Page<ClarificationCorrespondance> searchClarificationCorrespondances(@Param("appelOffreId") int appelOffreId, @Param("type") String correspondanceclrType,@Param("search") String search, Pageable pageable);
	
	
	
	@Query("SELECT c FROM ClarificationCorrespondance c "
			+ "INNER JOIN c.appelOffres appelOffre "
			+ "WHERE c.correspondanceclrType = :correspondanceclrType AND c.appelOffres.appelOffreId = :appelOffreId")
	Page<ClarificationCorrespondance> findByCorrespondanceclrType(int appelOffreId, String correspondanceclrType, Pageable pageable);
}  
