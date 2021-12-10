package com.vitrinaweb.vitrinaweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vitrinaweb.vitrinaweb.models.CompraModel;
import com.vitrinaweb.vitrinaweb.services.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CompraController {
    
    @Autowired
    CompraService compraService;

    @PostMapping("/compras")
    public ResponseEntity<Map<String, String>> guardar(@RequestBody CompraModel compra){
        this.compraService.guardarCompra(compra);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje","Se agregó correctamente");
        respuesta.put("estado", "true");

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/compras")
    public List<CompraModel> mostrar(){
        return this.compraService.traerCompra();
    }

    @PutMapping("/compras")
    public ResponseEntity<Map<String, String>> actualizar(@RequestBody CompraModel compra){
        this.compraService.guardarCompra(compra);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje","Se actualizó correctamente");

        return ResponseEntity.ok(respuesta);

    }
}
