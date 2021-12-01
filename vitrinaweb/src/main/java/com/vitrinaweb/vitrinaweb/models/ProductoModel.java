package com.vitrinaweb.vitrinaweb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="equipos")
public class ProductoModel {
    
    @Id
    private String id;
    private String nombre;
    private Long precio;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getPrecio() {
        return precio;
    }
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    
}
