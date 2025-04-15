package com.xtensus.passosyf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xtensus.passosyf.entities.Lot;

public interface LotRepository extends JpaRepository<Lot, Integer> {

	@Query("SELECT lot FROM Lot lot "
			+ "LEFT JOIN lot.secteurActivite secteurActivite LEFT JOIN lot.tauxTVA tauxTVA  "
			+ "INNER JOIN lot.appelOffre appelOffre "
			+ "WHERE (lot.lotLibelle LIKE %:search% OR lot.lotCode LIKE %:search% OR lot.lotObjet LIKE %:search% OR lot.secteurActivite.secteurActiviteLibelle LIKE %:search% OR lot.tauxTVA.tauxTVAValeur LIKE %:search% )"
			+ "AND lot.appelOffre.appelOffreId = :appelOffreId")
	Page<Lot> searchLots(@Param("search") String search,@Param("appelOffreId") int appelOffreId, Pageable pageable);

	Page<Lot> findByAppelOffre_appelOffreId(int appelOffreId ,Pageable pageable);

	List<Lot> findByAppelOffre_appelOffreId(int appelOffreId);
}
