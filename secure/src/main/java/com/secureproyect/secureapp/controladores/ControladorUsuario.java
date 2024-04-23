package com.secureproyect.secureapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.secureproyect.secureapp.contenedores.Usuario;
import com.secureproyect.secureapp.servicios.ServicioUsuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:3000")
public class ControladorUsuario {

    @Autowired
    ServicioUsuario servicioUsuario;

    public ControladorUsuario() {
    }

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping
    public void crearPersona(@RequestBody Usuario usuario) {
        servicioUsuario.crearUsuario(usuario);
    }

    @GetMapping
    public Flux<Usuario> obtenerUsuarios() {
        return servicioUsuario.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public Mono<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        return servicioUsuario.buscarUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioPorId(@PathVariable String id) {
        servicioUsuario.eliminarUsuarioPorId(id);
    }

    @PostMapping("/iniciarSesion")
    public Mono<ResponseEntity<Usuario>> iniciarSesion(@RequestBody Usuario usuario) {
        return servicioUsuario.iniciarSesion(usuario.getCorreo(), usuario.getContrasena())
                .map(u -> ResponseEntity.ok(u))
                .onErrorReturn(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
