package com.secureproyect.secureapp.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.secureproyect.secureapp.contenedores.Contrasena;
import com.secureproyect.secureapp.servicios.ServicioContrasena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contrasena")
public class ControladorContrasena {

    @Autowired
    ServicioContrasena servicioContrasena;

    public ControladorContrasena() {
    }

    public ControladorContrasena(ServicioContrasena servicioContrasena) {
        this.servicioContrasena = servicioContrasena;
    }

    @PostMapping
    public void CrearContrasena(@RequestBody Contrasena contrasena) {
        servicioContrasena.crearContrasena(contrasena);
    }
    
}
