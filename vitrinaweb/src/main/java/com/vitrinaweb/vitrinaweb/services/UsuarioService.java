package com.vitrinaweb.vitrinaweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import com.vitrinaweb.vitrinaweb.models.UsuarioModel;
import com.vitrinaweb.vitrinaweb.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired 
    UsuarioRepository usuarioRepository;

    public void guardar(UsuarioModel usuario) {
        this.usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> traerUsuarios() {
        return this.usuarioRepository.findAll();
    }


    public UsuarioModel buscarPorId(String id){
        return this.usuarioRepository.findById(id).orElse(new UsuarioModel());
    }

    public UsuarioModel buscarPorusername(String username){
       return this.usuarioRepository.findByUsername(username).orElse(new UsuarioModel());
    } 

    public void eliminar(String id) {
        this.usuarioRepository.deleteById(id);
    }
}
