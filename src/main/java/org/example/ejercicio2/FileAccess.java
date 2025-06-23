package org.example.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess extends  Acceso{
    public FileAccess(String nombreArchivo, String ruta) {
        super(nombreArchivo, ruta);
    }

    public String readFile() throws IOException {
        return Files.readString(Paths.get(this.ruta + "/" + this.nombreArchivo));
    }
}
