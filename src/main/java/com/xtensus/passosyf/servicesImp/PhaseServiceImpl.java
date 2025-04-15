package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Phase;
import com.xtensus.passosyf.repositories.PhaseRepository;
import com.xtensus.passosyf.services.PhaseService;

@Service
public class PhaseServiceImpl implements PhaseService {
	@Autowired
	PhaseRepository phaseDao;


	@Override
	public List<Phase> getAllPhases() {

		return phaseDao.findAll();
	}



	@Override
	public Phase getPhaseById(int id) {

		return phaseDao.findById(id).get();
	}

	@Override
	public Phase savePhase(Phase phase) {

		return phaseDao.save(phase);
	}

	@Override
	public void deletePhase(Phase phase) {

		phaseDao.delete(phase);

	}

	@Override
	public void deletePhaseById(int id) {

		phaseDao.deleteById(id);

	}
	
	
    @Override
    public Page<Phase> getPhasesByLotId(int lotId ,int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return phaseDao.findByLot_lotReference(lotId,pageable);
    }

    
    
    @Override
    public Page<Phase> searchPhases(String search,int lotId, int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return phaseDao.searchPhases(search ,lotId, pageable);
    }



	@Override
	public List<Phase> getPhasesByLotId(int lotId) {
		
		return phaseDao.findByLot_lotReference(lotId);
	}
}
