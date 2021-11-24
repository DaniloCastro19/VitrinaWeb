package com.example.VitrinaWeb.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.VitrinaWeb.models.ClienteModel;
import com.example.VitrinaWeb.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> traerCliente(){
        return clienteService.getCliente();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel Cliente){
        return clienteService.setCliente(Cliente);
    }
    @GetMapping(value="/{id}")
    public Optional<ClienteModel> traerId(@PathVariable("id") Long id) {
        return clienteService.getclienteId(id);
    }
        @GetMapping(value="/{nombre}")

    public ClienteModel traerNombre(@PathVariable("nombre") String nombre) {
        return clienteService.getclienteNombre(nombre);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminar(@PathVariable("id") Long id){
        boolean ok = this.clienteService.eliminarcliente(id);
        if (ok){
            return "Cliente eliminado";
        }
        else{
            return "Ha ocurrido un error al eliminar el Cliente";
        }
    }
}
