package com.secureproyect.secureapp.servicios;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secureproyect.secureapp.contenedores.Contrasena;
import com.secureproyect.secureapp.repositorios.RepositorioContrasena;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicioContrasena {

    @Autowired
    RepositorioContrasena repositorioContrasena;

    public ServicioContrasena() {
    }

    public ServicioContrasena(RepositorioContrasena repositorioContrasena) {
        this.repositorioContrasena = repositorioContrasena;
    }

    public void crearContrasena(Contrasena contrasena) {
        this.repositorioContrasena.save(contrasena).block();
    }

    public Flux<Contrasena> obtenerContrasenas() {
        return repositorioContrasena.findAll();
    }

    public Mono<Contrasena> buscarContrasenaPorId(String id) {
        return repositorioContrasena.findById(id);
    }

    public void eliminarContrasenaPorId(String id) {
        Mono<Contrasena> usuarioMono = repositorioContrasena.findById(id);
        usuarioMono.subscribe(
                contrasena -> {
                    repositorioContrasena.delete(contrasena).subscribe();
                    System.out.println("Usuario eliminado con éxito");
                },
                error -> {
                    System.out.println("Error al eliminar el usuario: " + error.getMessage());
                });
    }

    public Flux<Contrasena> obtenerContrasenasPorIdUsuario(String idUsuario) {
        return repositorioContrasena.findByIdUsuario(idUsuario);
    }

    public boolean validarContrasena(String contrasena, boolean incluirMayusculas, boolean incluirMinusculas,
            boolean incluirNumeros, boolean incluirSimbolos) {
        if (incluirMayusculas && !contrasena.matches(".*[A-Z].*")) {
            return false;
        }
        if (incluirMinusculas && !contrasena.matches(".*[a-z].*")) {
            return false;
        }
        if (incluirNumeros && !contrasena.matches(".*[0-9].*")) {
            return false;
        }
        if (incluirSimbolos && !contrasena.matches(".*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~].*")) {
            return false;
        }
        return true;
    }

    public String generarContrasena(boolean incluirMayusculas, boolean incluirMinusculas, boolean incluirNumeros,
            boolean incluirSimbolos, int longitud) {

        // Define los caracteres permitidos
        StringBuilder caracteresPermitidos = new StringBuilder();
        if (incluirMayusculas) {
            caracteresPermitidos.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (incluirMinusculas) {
            caracteresPermitidos.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (incluirNumeros) {
            caracteresPermitidos.append("0123456789");
        }
        if (incluirSimbolos) {
            caracteresPermitidos.append("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        }

        // Verifica que haya al menos un tipo de caracteres permitidos
        if (caracteresPermitidos.length() == 0) {
            throw new IllegalArgumentException("Debe seleccionar al menos un tipo de caracteres permitidos.");
        }

        Random random = new Random();
        StringBuilder contrasenaGenerada = new StringBuilder();

        // Genera la contraseña
        do {
            contrasenaGenerada.setLength(0); // Limpiar el StringBuilder para generar una nueva contraseña
            for (int i = 0; i < longitud; i++) {
                char caracter = caracteresPermitidos.charAt(random.nextInt(caracteresPermitidos.length()));
                contrasenaGenerada.append(caracter);
            }
        } while (!validarContrasena(contrasenaGenerada.toString(), incluirMayusculas, incluirMinusculas,
                incluirNumeros, incluirSimbolos)); // Repetir hasta que se genere una contraseña válida

        return "{ \"contrasena\": \"" + contrasenaGenerada.toString() + "\" }";
    }
}
