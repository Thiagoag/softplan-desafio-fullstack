package com.thiagoag.wsmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagoag.wsmongo.domain.LegalProcess;
import com.thiagoag.wsmongo.repository.LegalProcessRepository;
import com.thiagoag.wsmongo.services.exception.ObjectNotFoundException;

@Service
public class LegalProcessService {

	@Autowired
	private LegalProcessRepository lpRepo;
	
	public LegalProcess findById(String id) {
		Optional<LegalProcess> process = lpRepo.findById(id);
		return process.orElseThrow(() -> new ObjectNotFoundException("Process not found"));
	}
	
	public List<LegalProcess> findByProcessNumber(String text){
		return lpRepo.findByProcessNumberContainingIgnoreCase(text);
	}
	
	public List<LegalProcess> fullSearch(String text, Date minDate, Date maxDate){
		maxDate  = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return lpRepo.fullSearch(text, minDate, maxDate);
	}
	
}
