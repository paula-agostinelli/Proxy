package org.example.ejercicio2;

import java.io.IOException;

public class FileAccessProxy extends Acceso{
    private FileAccess fileAccess;
    private Usuario usuario;

    public FileAccessProxy(String nombreArchivo, String ruta, FileAccess file, Usuario usuario) {
        super(nombreArchivo, ruta);
        this.fileAccess = file;
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {

        if (nombreArchivo.charAt(0) != 'I' && nombreArchivo.charAt(0) != 'M'){
            return fileAccess.readFile();
        }
        if (nombreArchivo.charAt(0) == 'M' && (usuario.poseePermiso(EnumPermiso.ADMIN) || usuario.poseePermiso(EnumPermiso.INTERMEDIO))){
            return fileAccess.readFile();
        }
        else if (this.usuario.poseePermiso(EnumPermiso.ADMIN)) {
            return fileAccess.readFile();
        }
        return "No posees los permisos para ver este archivo.";
    }
}

