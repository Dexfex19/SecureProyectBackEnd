package com.secureproyect.secureapp.contenedores;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Component
@Container(containerName = "Contrasena")

public class Contrasena {

    @Id
    private String id;
    private String idUsuario;
    private String descripcion;
    private String contenido;

    public Contrasena(String idUsuario, String descripcion, String contenido) {
        this.id = UUID.randomUUID().toString(); // Generar un UUID único
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Contrasena() {
        this.id = UUID.randomUUID().toString(); // Generar un UUID único
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", idUsuario='" + getIdUsuario() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                ", contenido='" + getContenido() + "'" +
                "}";
    }

}
