package com.vitrinaweb.vitrinaweb.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vitrinaweb.vitrinaweb.models.UsuarioModel;
import com.vitrinaweb.vitrinaweb.services.UsuarioService;
import com.vitrinaweb.vitrinaweb.utils.Autorizacion;
import com.vitrinaweb.vitrinaweb.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api")
// @Component
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/verificar")
    public ResponseEntity<Map<String,Boolean>> verificarToken(){
        Map<String,Boolean> respuesta= new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity.ok(respuesta);

    }


    @PostMapping("/usuarios")
    public ResponseEntity<Map<String, String>> guardarUsuarios(@RequestBody UsuarioModel usuario){
        
   
        Map<String, String> respuesta= new HashMap<>();
        
   
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
       
       
        UsuarioModel u=this.usuarioService.buscarPorusername(usuario.getUsername());
        if(u.getId()==null){
            this.usuarioService.guardar(usuario);
            respuesta.put("mensaje","Se agregó correctamente");
        }else{
            respuesta.put("mensaje","Usuario ya existe");
        }

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UsuarioModel usuario){
        UsuarioModel usuarioAux=this.usuarioService.buscarPorusername(usuario.getUsername());
        Map<String, String> respuesta = new HashMap<>();
        if(usuarioAux.getUsername()==null){
            respuesta.put("mensaje","usuario o contraseña incorrectos");
        }else{
            if(!BCrypt.checkpw(usuario.getPassword(), usuarioAux.getPassword())){
                respuesta.put("mensaje","usuario o contraseña incorrectos");
            }else{
                String hash ="";
                long tiempo = System.currentTimeMillis();
                if(usuarioAux.getId()!=null){
                    hash=Jwts.builder()
                           .signWith(SignatureAlgorithm.HS256, Autorizacion.KEY)
                           .setSubject(usuarioAux.getNombre())
                           .setIssuedAt(new Date(tiempo))
                           .setExpiration(new Date(tiempo+900000))
                           .claim("username", usuarioAux.getUsername())
                           .claim("correo", usuarioAux.getCorreo())
                           .compact();
                }
                usuarioAux.setHash(hash);
                respuesta.put("mensaje","Accedió correctamente");
                respuesta.put("token",hash);
                respuesta.put("id",usuarioAux.getId());
                respuesta.put("nombre",usuarioAux.getNombre());
                respuesta.put("correo",usuarioAux.getCorreo());
                respuesta.put("username",usuarioAux.getUsername());
            }
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/usuarios") 
    public List<UsuarioModel> traerUsuarios(){
        return this.usuarioService.traerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioModel traerId(@PathVariable String id) {
        return this.usuarioService.buscarPorId(id);
    }

    @GetMapping("/usuarios/login") 
    public List<UsuarioModel> traerLogin(){
        return this.usuarioService.traerUsuarios();
    }

    @PutMapping("/usuarios") 
    public ResponseEntity<Map<String, String>> actualizarUsuario(@RequestBody UsuarioModel usuario){
        
        this.usuarioService.guardar(usuario);
        Map<String, String> respuesta= new HashMap<>();
        respuesta.put("mensaje","Se actualizó correctamente");

        return ResponseEntity.ok(respuesta);
        }


}


