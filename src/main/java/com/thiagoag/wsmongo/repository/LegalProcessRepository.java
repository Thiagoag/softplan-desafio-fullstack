package com.thiagoag.wsmongo.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagoag.wsmongo.domain.LegalProcess;

@Repository
public interface LegalProcessRepository extends MongoRepository<LegalProcess, String>{

	List<LegalProcess> findByProcessNumberContainingIgnoreCase(String text);
}
