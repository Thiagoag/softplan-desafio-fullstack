package com.thiagoag.wsmongo.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.thiagoag.wsmongo.domain.LegalProcess;

@Repository
public interface LegalProcessRepository extends MongoRepository<LegalProcess, String>{

	List<LegalProcess> findByProcessNumberContainingIgnoreCase(String text);

	@Query("{ 'processNumber': { $regex: ?0, $options: 'i' } }")
	List<LegalProcess> findByProcNumQuery(String text);
}
