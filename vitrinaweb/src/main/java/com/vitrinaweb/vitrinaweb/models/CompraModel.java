package com.vitrinaweb.vitrinaweb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="compras")
public class CompraModel {
    @Id
    private String id;
    private UsuarioModel idUsuario; 
    private ProductoModel idProducto; 
    private String fecha;

    public UsuarioModel getIdUsuario() {
        return idUsuario;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public ProductoModel getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(ProductoModel idProducto) {
        this.idProducto = idProducto;
    }
    public void setIdUsuario(UsuarioModel idUsuario) {
        this.idUsuario = idUsuario;
    }

}
