package com.example.VitrinaWeb.services;


import java.util.ArrayList;
import java.util.Optional;

import com.example.VitrinaWeb.models.ClienteModel;
import com.example.VitrinaWeb.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository; 
    
    public ArrayList<ClienteModel> getCliente(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();}

        public ClienteModel setCliente(ClienteModel cliente){
            
            return clienteRepository.save(cliente);
    }
    
    public Optional<ClienteModel> getclienteId(Long id){
        return clienteRepository.findById(id);
    }
    public ClienteModel getclienteNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public boolean eliminarcliente (Long id){
        try {
            clienteRepository.deleteById(id);
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}

