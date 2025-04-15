package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Lot;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.LotRepository;
import com.xtensus.passosyf.services.LotService;

@Service
public class LotServiceImpl implements LotService {
	@Autowired
	LotRepository lotDao;


	@Override
	public List<Lot> getAllLots() {

		return lotDao.findAll();
	}



	@Override
	public Lot getLotById(int id) {

		return lotDao.findById(id)
		        .orElseThrow (()-> new NotFoundException("Lot with ID : "+id+" Not Found!"));
	}

	@Override
	public Lot saveLot(Lot lot) {

		return lotDao.save(lot);
	}

	@Override
	public void deleteLot(Lot lot) {

		lotDao.delete(lot);

	}

	@Override
	public void deleteLotById(int id) {

        try {    
        	lotDao.deleteById(id);
            ResponseEntity.ok().body("Lot deleted with success!"); 

    		}
            catch (DataIntegrityViolationException e) {
            	throw new DataIntegrityViolationException("Cannot delete Lot with ID \""+id+"\" because it is referenced by other objects ");
            }

	}
	
	
    @Override
    public Page<Lot> getLotsByAppelOffreId(int appelOffreId ,int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return lotDao.findByAppelOffre_appelOffreId(appelOffreId,pageable);
    }

    
    
    @Override
    public Page<Lot> searchLots(String search,int appelOffreId, int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return lotDao.searchLots(search ,appelOffreId, pageable);
    }



	@Override
	public List<Lot> getLotsByAppelOffreId(int appelOffreId) {
		
		return lotDao.findByAppelOffre_appelOffreId(appelOffreId);
	}
	
}
