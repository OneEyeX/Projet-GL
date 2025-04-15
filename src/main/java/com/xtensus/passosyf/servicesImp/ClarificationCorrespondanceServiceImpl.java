package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.ClarificationCorrespondance;
import com.xtensus.passosyf.repositories.ClarificationCorrespondanceRepository;
import com.xtensus.passosyf.services.ClarificationCorrespondanceService;

@Service
public class ClarificationCorrespondanceServiceImpl implements ClarificationCorrespondanceService {
     
	 @Autowired
     ClarificationCorrespondanceRepository clarificationCorrespondanceDao ;
  
	 @Override
	 public List<ClarificationCorrespondance> getAllClarificationCorrespondances() {
		 return clarificationCorrespondanceDao.findAll();
	 }
	 
		@Override
		public ClarificationCorrespondance getClarificationCorrespondanceById(int id) {

			return clarificationCorrespondanceDao.findById(id).get();
		}
	 
		@Override
		public ClarificationCorrespondance saveClarificationCorrespondance(ClarificationCorrespondance clarificationCorrespondance) {

			return clarificationCorrespondanceDao.save(clarificationCorrespondance);
		}
		

		@Override
		public void deleteClarificationCorrespondanceById(int id) {

			clarificationCorrespondanceDao.deleteById(id);

		}
		
	    @Override
	    public Page<ClarificationCorrespondance> getAllClarificationCorrespondancesByType(int appelOffreId, String correspondanceclrType ,int pageNum, int pageSize, String sortField, String sortDir) {
	        Sort sort = Sort.by(sortField);
	        if (sortDir.equalsIgnoreCase("desc")) {
	            sort = sort.descending();
	        }
	        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
	        return clarificationCorrespondanceDao.findByCorrespondanceclrType( appelOffreId, correspondanceclrType,pageable);
	    }

	    
	    
	    @Override
	    public Page<ClarificationCorrespondance> searchClarificationCorrespondances(int appelOffreId, String correspondanceclrType, String search, int pageNum, int pageSize, String sortField, String sortDir) {
	        Sort sort = Sort.by(sortField);
	        if (sortDir.equalsIgnoreCase("desc")) {
	            sort = sort.descending();
	        }
	        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
	        return clarificationCorrespondanceDao.searchClarificationCorrespondances( appelOffreId, correspondanceclrType, search , pageable);
	    }

 



}
