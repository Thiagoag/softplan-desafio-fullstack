package com.thiagoag.wsmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagoag.wsmongo.domain.LegalProcess;
import com.thiagoag.wsmongo.services.LegalProcessService;

@RestController
@RequestMapping(value="/processes")
public class LegalProcessResource {

	@Autowired
	private LegalProcessService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<LegalProcess> findById(@PathVariable String id){
		LegalProcess obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}

}
