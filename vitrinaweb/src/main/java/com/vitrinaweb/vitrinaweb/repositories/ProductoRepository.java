package com.vitrinaweb.vitrinaweb.repositories;

import com.vitrinaweb.vitrinaweb.models.ProductoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<ProductoModel, String>{

}
    

