package com.vitrinaweb.vitrinaweb.utils;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class Autorizacion implements Filter{
    
    public static final String KEY="dndsjkfjksddsfdfgfdbf";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        String url =httpServletRequest.getRequestURI();
        if(url.contains("/api/usuarios")||url.contains("/api/usuarios/login")||url.contains("index")){
            chain.doFilter(request, response); 
        }else{
            String hash=httpServletRequest.getHeader("Authorization");
            if(hash==null || hash.trim().equals("")){
                response.setContentType("application/json");
                String body="{\"autorizacion\":\"NO\"}";
                response.getWriter().write(body);
            }
            try {
                Jws<Claims> claims=Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                if((url.contains("/api/productos")||url.contains("/api/compras"))&&(!claims.getBody().get("username").equals(""))){
                    chain.doFilter(request, response);    
                }

            } catch (Exception e) {
                response.setContentType("application/json");
                String body="{\"autorizacion\":\"TOKEN NO VALIDO\"}";
                response.getWriter().write(body);
            }
        }
    }
}

