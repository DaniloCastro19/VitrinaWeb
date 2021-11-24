package com.example.VitrinaWeb.repositories;


import com.example.VitrinaWeb.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
    public abstract ClienteModel findByNombre(String nombre);
}
