package com.secureproyect.secureapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secureproyect.secureapp.Repos.RepositorioUsuario;
import com.secureproyect.secureapp.containers.Usuario;

@Service
public class ServicioUsuario {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void crearUsuario(Usuario usuario){
        repositorioUsuario.save(usuario);
    }
}
