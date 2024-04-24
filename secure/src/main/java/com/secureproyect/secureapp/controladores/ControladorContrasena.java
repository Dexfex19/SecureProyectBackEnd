package com.secureproyect.secureapp.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.secureproyect.secureapp.contenedores.Contrasena;
import com.secureproyect.secureapp.contenedores.RequisitosContrasena;
import com.secureproyect.secureapp.servicios.ServicioContrasena;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/contrasena")
@CrossOrigin(origins = "https://victorious-coast-075ddca0f.5.azurestaticapps.net")
public class ControladorContrasena {

    @Autowired
    ServicioContrasena servicioContrasena;

    public ControladorContrasena() {
    }

    public ControladorContrasena(ServicioContrasena servicioContrasena) {
        this.servicioContrasena = servicioContrasena;
    }

    @PostMapping
    public void CrearContrasena(@RequestBody Contrasena contrasena) {
        servicioContrasena.crearContrasena(contrasena);
    }

    @GetMapping
    public Flux<Contrasena> obtenerContrasenas() {
        return servicioContrasena.obtenerContrasenas();
    }

    @GetMapping("/{id}")
    public Mono<Contrasena> buscarContrasenaPorId(@PathVariable String id) {
        return servicioContrasena.buscarContrasenaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarContrasenaPorId(@PathVariable String id) {
        servicioContrasena.eliminarContrasenaPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public Flux<Contrasena> obtenerContrasenasPorIdUsuario(@PathVariable String idUsuario) {
        return servicioContrasena.obtenerContrasenasPorIdUsuario(idUsuario);
    }

    @PostMapping("/generar")
    public String generarContrasena(@RequestBody RequisitosContrasena requisitos) {
        return servicioContrasena.generarContrasena(
                requisitos.isIncluirMayusculas(),
                requisitos.isIncluirMinusculas(),
                requisitos.isIncluirNumeros(),
                requisitos.isIncluirSimbolos(),
                requisitos.getLongitud());
    }

}
