package com.xtensus.passosyf.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xtensus.passosyf.entities.Soumissionnaire;


public interface SoumissionnaireRepository extends JpaRepository<Soumissionnaire, Integer >{
	public List<Soumissionnaire> findByOrderBySoumissionnaireReferenceDesc();
	
	
	@Query(value = "select * from soumissionnaire "
			+ " where  soumissionnaireMatriculeFiscale like %:search% or  soumissionnaireRaisonSociale like %:search% or "
			+ " soumissionnaireNumeroRegistreCommerce like %:search%   "
			,nativeQuery=true)
	public Page<Soumissionnaire> findAllSoumissionnaire(String search,Pageable pageable);

	
	@Query(value=" select s.* from soumissionnaire s , appeloffresoumissionnaire aos where "
			+ " s.soumissionnaireReference=aos.soumissionnaireReference and aos.appeloffresId= :appelOffreReference "
			+ " and (s.soumissionnaireReference like %:search% or s.soumissionnaireRaisonSociale like %:search%  or s.soumissionnaireAdresseSiegeSocial like %:search% "
			+ "	 or s.soumissionnaireAnneeCreation like %:search% )"
			,nativeQuery = true)
    Page<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreReference,String search ,Pageable pageable);
	
	@Query(value=" select s.* from soumissionnaire s , appeloffresoumissionnaire aos where "
			+ " s.soumissionnaireReference=aos.soumissionnaireReference and aos.appeloffresId= :appelOffreReference"
			,nativeQuery = true)
    List<Soumissionnaire> soumissionnaireByAppelOffreReference(int appelOffreReference);

	Soumissionnaire findBySoumissionnaireMatriculeFiscal(String matricule);

	
	
	@Query(value="select count(d.soumissionnaire) from dossier d where d.soumissionnaire= :soumissionnaireId"
			,nativeQuery=true)
	Integer isUsedBySoumissionnaireId(Integer soumissionnaireId);

}
