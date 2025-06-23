package org.example.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "permiso-tp.txt";
    public static final String RUTA = "C:\\Users\\Paula Agostinelli\\Downloads";

    public static void main(String[] args) {
        List<EnumPermiso> permisos = new ArrayList<>();
        permisos.add(EnumPermiso.ADMIN);
        var usuario = new Usuario("Paula", permisos);
        var file = new FileAccess(FILE_NAME, RUTA);
        FileAccessProxy fileProxy = new FileAccessProxy(FILE_NAME,RUTA, file, usuario);
        try {
            System.out.println(fileProxy.readFile());
        } catch (IOException e) {
            System.out.println("no se encontro el archivo");
        }
    }
}
