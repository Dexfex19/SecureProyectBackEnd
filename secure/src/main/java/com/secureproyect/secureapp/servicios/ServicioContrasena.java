package com.secureproyect.secureapp.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secureproyect.secureapp.contenedores.Contrasena;
import com.secureproyect.secureapp.repositorios.RepositorioContrasena;

@Service
public class ServicioContrasena {

    @Autowired
    RepositorioContrasena repositorioContrasena;

    @Autowired
    Contrasena contrasena;

    public ServicioContrasena(){

    }

    public ServicioContrasena(RepositorioContrasena repositorioContrasena){
        this.repositorioContrasena = repositorioContrasena;
    }

    public void crearContrasena(Contrasena contrasena){
        this.repositorioContrasena.save(contrasena).block();
    }

    public boolean verificarSimbolos(Contrasena contrasena){
        
        //Las contrasenas deberan tener por lo menos un minimo de 8 caracteres, una mayuscula, un numero y un simbolo.
        Set<Character> simbolosPermitidos = new HashSet<>();
        char[] poolSimbolos = {'!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', 
        '/', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '{', '}', '|', '~'};

        for(char simbolo : poolSimbolos){
            simbolosPermitidos.add(simbolo);
        }

        for (char caracter : contrasena.getContenido().toCharArray()) {
            if (!simbolosPermitidos.contains(caracter) && !Character.isLetterOrDigit(caracter) && !Character.isWhitespace(caracter)){
                System.out.println("La contrasena tiene un caracterno valido");
                return false;
            }
        }

        return true;
    }

    public int contarSimbolos(Contrasena contrasena){

        Set<Character> simbolosPermitidos = new HashSet<>();
        char[] poolSimbolos = {'!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', 
        '/', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '{', '}', '|', '~'};

        int contadorSimbolos = 0;

        for(char simbolo : poolSimbolos){
            simbolosPermitidos.add(simbolo);
        }

        for (char caracter : contrasena.getContenido().toCharArray()) {
            if (simbolosPermitidos.contains(caracter)){
                contadorSimbolos++;
            }
        }

        return contadorSimbolos;
    }

    public int contarNumeros(Contrasena contrasena){

        int cantNumeros = 0;

        for (char caracter : contrasena.getContenido().toCharArray()) {
            if (Character.isDigit(caracter)) {
                cantNumeros++;
            }
        }
        return cantNumeros;
    }

    public int contarTotalCaracteres(Contrasena contrasena){
        return contrasena.getContenido().length();
    }

    public int contatMayus(Contrasena contrasena){
        int cantMayus = 0;

        for (char caracter : contrasena.getContenido().toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                cantMayus++;
            }
        }

        return cantMayus;
    }
}
