package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xtensus.passosyf.entities.TypeMarche;
import com.xtensus.passosyf.repositories.TypeMarcheRepository;
import com.xtensus.passosyf.services.TypeMarcheService;


@Service
@Transactional
public class TypeMarcheServiceImpl implements TypeMarcheService {

	
	private TypeMarcheRepository typeMarcheRepository;
	
	
	public TypeMarcheServiceImpl(TypeMarcheRepository typeMarcheRepository) {
		this.typeMarcheRepository = typeMarcheRepository;
	}

	@Override
	public TypeMarche save(TypeMarche typeMarche) {

		return typeMarcheRepository.save(typeMarche);
	}

	@Override
	public TypeMarche update(TypeMarche typeMarche, Integer id) {
		typeMarche.setTypeMarcheId(id);
		return typeMarcheRepository.save(typeMarche);
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		
		try {
			typeMarcheRepository.deleteById(id);
			return new ResponseEntity<>("",HttpStatus.OK);
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		
		}
	}

	@Override
	public List<TypeMarche> ListTypeMarche() {
		return typeMarcheRepository.findAll();
	}

	@Override
	public TypeMarche getTypeMarcheById(Integer id) {
		return typeMarcheRepository.findById(id).get();
	}

}
