package com.xtensus.passosyf.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.xtensus.passosyf.entities.TypeMarche;

public interface TypeMarcheService {
	
	  	public TypeMarche save(TypeMarche typeMarche);
	    public TypeMarche update(TypeMarche typeMarche,Integer id);
	    public ResponseEntity<?> delete(Integer id);
	    public List<TypeMarche> ListTypeMarche();
	    public TypeMarche getTypeMarcheById(Integer id);
}
