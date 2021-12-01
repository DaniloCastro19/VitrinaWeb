package com.vitrinaweb.vitrinaweb.services;
import java.util.List;
import java.util.Optional;

import com.vitrinaweb.vitrinaweb.models.ProductoModel;
import com.vitrinaweb.vitrinaweb.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired 
    ProductoRepository productoRepository; 

 
    public void guardarProductos(ProductoModel producto) {
        this.productoRepository.save(producto);
    }


    public List<ProductoModel> traerProductos() {
        return this.productoRepository.findAll();
    }


    public Optional<ProductoModel> buscarPorId(String id) {
         return this.productoRepository.findById(id);
    }

 
    public Boolean verificar(String id) {
        return this.productoRepository.existsById(id);
    }


    public void eliminar(String id) {
        this.productoRepository.deleteById(id);
    }
 
}
