package com.vitrinaweb.vitrinaweb.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vitrinaweb.vitrinaweb.models.ProductoModel;
import com.vitrinaweb.vitrinaweb.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductoController {

    @Autowired 
    ProductoService productoService;

    @PostMapping("/productos") 
    public ResponseEntity<Map<String, String>> guardarProducto(ProductoModel producto){

      this.productoService.guardarProductos(producto);

      Map<String, String> respuesta = new HashMap<>();
      respuesta.put("mensaje","Se añadió correctamente");
      respuesta.put("estado","true");
      return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/productos") 
    public List<ProductoModel> traerProductos(){
        return this.productoService.traerProductos();
    }


    @GetMapping("/productos/{id}") 
    public ProductoModel traerProductoPorId(@PathVariable String id){
        return this.productoService.buscarPorId(id).get();
    }
}
