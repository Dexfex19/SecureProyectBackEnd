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

    public void crearUsuario(Usuario usuario){
        repositorioUsuario.save(usuario).block();
    }

    public Flux<Usuario> obtenerUsuarios(){
        return repositorioUsuario.findAll();
    }

    public void eliminarUsuario(Integer id){
        Mono<Usuario> UsuarioMono = repositorioUsuario.findById(id);

        UsuarioMono.subscribe(
            usuario -> {
                repositorioUsuario.delete(usuario).subscribe();
                System.out.println("Usuario eliminado con éxito");
            },
            error -> {
                System.out.println("Error al eliminar el usuario: " + error.getMessage());
            }
        );
    }
}
