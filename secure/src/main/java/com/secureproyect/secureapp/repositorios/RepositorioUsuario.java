package com.secureproyect.secureapp.repositorios;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.secureproyect.secureapp.contenedores.Usuario;

import reactor.core.publisher.Mono;

@Repository
public interface RepositorioUsuario extends ReactiveCosmosRepository<Usuario, String> {
    Mono<Usuario> findByCorreo(String correo);
}
