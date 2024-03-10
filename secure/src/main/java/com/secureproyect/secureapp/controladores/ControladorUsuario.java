package com.secureproyect.secureapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secureproyect.secureapp.contenedores.Usuario;
import com.secureproyect.secureapp.servicios.ServicioUsuario;

import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping
    public Flux<Usuario> obtenerUsuarios() {
        return servicioUsuario.obtenerUsuarios(); 
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        servicioUsuario.eliminarUsuario(id);
    }
    
}
