package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Devise;
import com.xtensus.passosyf.repositories.DeviseRepository;
import com.xtensus.passosyf.services.DeviseService;

@Service
public class DeviseServiceImpl implements DeviseService {

	@Autowired
	DeviseRepository deviseDao;


	@Override
	public List<Devise> getAllDevises() {

		return deviseDao.findAll();
	}



	@Override
	public Devise getDeviseById(int id) {

		return deviseDao.findById(id).get();
	}

	@Override
	public Devise saveDevise(Devise devise) {

		return deviseDao.save(devise);
	}

	@Override
	public void deleteDevise(Devise devise) {

		deviseDao.delete(devise);

	}

	@Override
	public void deleteDeviseById(int id) {

		deviseDao.deleteById(id);

	}
	
	
    @Override
    public Page<Devise> getAllDevises(int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return deviseDao.findAll(pageable);
    }

    
    
    @Override
    public Page<Devise> searchDevises(String search, int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return deviseDao.searchDevises(search , pageable);
    }
}
