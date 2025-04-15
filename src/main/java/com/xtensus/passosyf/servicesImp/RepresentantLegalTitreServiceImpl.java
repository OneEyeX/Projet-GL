package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.RepresentantLegalTitre;
import com.xtensus.passosyf.repositories.RepresentantLegalTitreRepository;
import com.xtensus.passosyf.services.RepresentantLegalTitreService;

@Service
public class RepresentantLegalTitreServiceImpl implements RepresentantLegalTitreService {

	private RepresentantLegalTitreRepository RepresentantLegalTitreServiceRepository;

	public RepresentantLegalTitreServiceImpl(RepresentantLegalTitreRepository RepresentantLegalTitreServiceRepository) {
		this.RepresentantLegalTitreServiceRepository = RepresentantLegalTitreServiceRepository;
	}

	@Override
	public RepresentantLegalTitre save(RepresentantLegalTitre representantLegalTitre) {

		return RepresentantLegalTitreServiceRepository.save(representantLegalTitre);
	}

	@Override
	public RepresentantLegalTitre update(RepresentantLegalTitre representantLegalTitre, Integer id) {
		representantLegalTitre.setRepresentantLegalTitreId(id);
		return RepresentantLegalTitreServiceRepository.save(representantLegalTitre);
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {

		try {
			RepresentantLegalTitreServiceRepository.deleteById(id);
			return new ResponseEntity<>("", HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());

		}
	}

	@Override
	public List<RepresentantLegalTitre> ListRepresentantLegalTitre() {
		return RepresentantLegalTitreServiceRepository.findAll();
	}

	@Override
	public RepresentantLegalTitre getRepresentantLegalTitreById(Integer id) {
		return RepresentantLegalTitreServiceRepository.findById(id).get();
	}

}
