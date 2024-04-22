package com.secureproyect.secureapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secureproyect.secureapp.contenedores.Usuario;
import com.secureproyect.secureapp.repositorios.RepositorioUsuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicioUsuario {

    public ServicioUsuario() {
    }

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void crearUsuario(Usuario usuario) {
        repositorioUsuario.save(usuario).block();
    }

    public Flux<Usuario> obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Mono<Usuario> buscarUsuarioPorId(String id) {
        return repositorioUsuario.findById(id);
    }

    public void eliminarUsuarioPorId(String id) {
        Mono<Usuario> usuarioMono = repositorioUsuario.findById(id);
        usuarioMono.subscribe(
                usuario -> {
                    repositorioUsuario.delete(usuario).subscribe();
                    System.out.println("Usuario eliminado con éxito");
                },
                error -> {
                    System.out.println("Error al eliminar el usuario: " + error.getMessage());
                });
    }

    public Mono<Usuario> iniciarSesion(String correo, String contrasena) {
        return repositorioUsuario.findByCorreo(correo)
                .filter(usuario -> usuario.getContrasena().equals(contrasena))
                .switchIfEmpty(Mono.error(new RuntimeException("El correo o la contraseña están incorrectos")));
    }

}
