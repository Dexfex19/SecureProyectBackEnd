package com.secureproyect.secureapp.contenedores;

public class RequisitosContrasena {
    private boolean incluirMayusculas;
    private boolean incluirMinusculas;
    private boolean incluirNumeros;
    private boolean incluirSimbolos;
    private int longitud;
    private String idUsuario;
    private String descripcion;

    public boolean isIncluirMayusculas() {
        return this.incluirMayusculas;
    }

    public boolean getIncluirMayusculas() {
        return this.incluirMayusculas;
    }

    public void setIncluirMayusculas(boolean incluirMayusculas) {
        this.incluirMayusculas = incluirMayusculas;
    }

    public boolean isIncluirMinusculas() {
        return this.incluirMinusculas;
    }

    public boolean getIncluirMinusculas() {
        return this.incluirMinusculas;
    }

    public void setIncluirMinusculas(boolean incluirMinusculas) {
        this.incluirMinusculas = incluirMinusculas;
    }

    public boolean isIncluirNumeros() {
        return this.incluirNumeros;
    }

    public boolean getIncluirNumeros() {
        return this.incluirNumeros;
    }

    public void setIncluirNumeros(boolean incluirNumeros) {
        this.incluirNumeros = incluirNumeros;
    }

    public boolean isIncluirSimbolos() {
        return this.incluirSimbolos;
    }

    public boolean getIncluirSimbolos() {
        return this.incluirSimbolos;
    }

    public void setIncluirSimbolos(boolean incluirSimbolos) {
        this.incluirSimbolos = incluirSimbolos;
    }

    public int getLongitud() {
        return this.longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
