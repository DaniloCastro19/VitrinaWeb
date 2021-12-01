package com.vitrinaweb.vitrinaweb.services;

import java.util.List;

import com.vitrinaweb.vitrinaweb.models.CompraModel;
import com.vitrinaweb.vitrinaweb.repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

   
    @Autowired
    CompraRepository compraRepository;


    public void guardarCompra(CompraModel Compra){
        this.compraRepository.save(Compra);
     }
 
 
   
     public List<CompraModel> traerCompra(){
         return this.compraRepository.findAll();
     }
 
     public CompraModel getCompra(String id){
       return  this.compraRepository.findById(id).orElse(new CompraModel());
     }
 

}
