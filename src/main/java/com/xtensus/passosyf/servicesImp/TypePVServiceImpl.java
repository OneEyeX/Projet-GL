package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TypePV;
import com.xtensus.passosyf.repositories.TypePVRepository;
import com.xtensus.passosyf.services.TypePVService;

@Service
public class TypePVServiceImpl implements TypePVService {

	@Autowired
	TypePVRepository typePVDao;

	@Override
	public List<TypePV> getAllTypePVs() {

		return typePVDao.findAll();
	}


	@Override
	public TypePV getTypePVById(int id) {

		return typePVDao.findById(id).get();
	}

	@Override
	public TypePV saveTypePV(TypePV typePV) {

		return typePVDao.save(typePV);
	}

	@Override
	public void deleteTypePV(TypePV typePV) {

		typePVDao.delete(typePV);

	}

	@Override
	public void deleteTypePVById(int id) {

		typePVDao.deleteById(id);

	}
}
