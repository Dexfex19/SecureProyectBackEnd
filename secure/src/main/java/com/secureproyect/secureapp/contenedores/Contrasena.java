package com.secureproyect.secureapp.contenedores;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Component
@Container(containerName = "Contrasena")
public class Contrasena {
    
    @Id
    private Integer id = 1;
    private String contenido;
    
    public Contrasena() {
    }

    public Contrasena(Integer id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public Contrasena(String contenido){
        this.contenido = contenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Contrasena [id=" + id + ", contenido=" + contenido + "]";
    }

}
