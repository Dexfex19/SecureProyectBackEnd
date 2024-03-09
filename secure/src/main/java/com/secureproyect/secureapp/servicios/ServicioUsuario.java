package com.secureproyect.secureapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secureproyect.secureapp.contenedores.Usuario;
import com.secureproyect.secureapp.repositorios.RepositorioUsuario;

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
}
