package com.secureproyect.secureapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secureproyect.secureapp.contenedores.Usuario;
import com.secureproyect.secureapp.servicios.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    ServicioUsuario servicioUsuario;

    public ControladorUsuario() {
    }

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping
    public void crearPersona(@RequestBody Usuario usuario){
        servicioUsuario.crearUsuario(usuario);
    }
}
