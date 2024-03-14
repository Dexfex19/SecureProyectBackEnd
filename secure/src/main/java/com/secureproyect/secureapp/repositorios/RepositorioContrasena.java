package com.secureproyect.secureapp.repositorios;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.secureproyect.secureapp.contenedores.Contrasena;

@Repository
public interface RepositorioContrasena extends ReactiveCosmosRepository<Contrasena, Integer>{
    
}
