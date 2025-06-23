package org.example.ejercicio2;

import java.util.List;

public class Usuario {
    private String nombre;
    private List<EnumPermiso> permisos;
    public Usuario(String nombre, List<EnumPermiso> permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }
    public boolean poseePermiso(EnumPermiso permiso) {
        return permisos.stream().anyMatch(p -> p.equals(permiso));
    }
}
