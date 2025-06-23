package org.example.ejercicio2;

import java.io.IOException;

public class Acceso {
    String ruta;
    String nombreArchivo;

    public Acceso(String nombreArchivo, String ruta) {
        this.nombreArchivo = nombreArchivo;
        this.ruta = ruta;
    }

    public abstract String readFile() throws IOException;
}
