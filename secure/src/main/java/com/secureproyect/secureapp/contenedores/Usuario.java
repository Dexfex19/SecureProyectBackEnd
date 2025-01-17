package com.secureproyect.secureapp.contenedores;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "Usuario")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasena;
    private ArrayList<String> contrasenasGuardadas;

    @PartitionKey
    private String correo;

    public Usuario(String id, String nombre, String apellido, String nombreUsuario, String contrasena,
            ArrayList<String> contrasenasGuardadas, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.contrasenasGuardadas = contrasenasGuardadas;
        this.correo = correo;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<String> getContrasenasGuardadas() {
        return contrasenasGuardadas;
    }

    public void setContrasenasGuardadas(ArrayList<String> contrasenasGuardadas) {
        this.contrasenasGuardadas = contrasenasGuardadas;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario() {
        this.id = UUID.randomUUID().toString(); // Generar un UUID único
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario="
                + nombreUsuario + ", contrasena=" + contrasena + ", contrasenasGuardadas=" + contrasenasGuardadas
                + ", correo=" + correo + "]";
    }
}
