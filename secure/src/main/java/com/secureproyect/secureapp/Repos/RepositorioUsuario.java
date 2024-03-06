package com.secureproyect.secureapp.Repos;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.secureproyect.secureapp.containers.Usuario;

@Repository
public interface RepositorioUsuario extends ReactiveCosmosRepository<Usuario, Integer> {

}
