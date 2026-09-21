package src.Sesion1_File;

import java.io.File;
import java.io.IOException;

public class Ejercicio3_param {
    public static void main(String[] args) throws IOException {

        // Instancio el objeto del fichero del usuario
        File ficheroUsuario = new File(args[0]);

        // Otro opción para crear y comprobar
        if(ficheroUsuario.createNewFile()){
            System.out.println("Fichero creado");
        }else{
            System.out.println("Ya existia");
        }

    }

}
