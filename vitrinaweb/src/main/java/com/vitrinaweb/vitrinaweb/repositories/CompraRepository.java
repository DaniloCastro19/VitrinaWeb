package com.vitrinaweb.vitrinaweb.repositories;

import com.vitrinaweb.vitrinaweb.models.CompraModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends MongoRepository<CompraModel,String>{
    
}
