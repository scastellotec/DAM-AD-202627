package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        // 5.3 Crea un fichero e informa de si se ha creado o ya existía.
        // Hazlo en una de estas dos versiones: leyendo el nombre con
        // Scanner o recibiéndolo como argumento en args[].

        // Declaro variables para recoger valor introducido por usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre de archivo: ");
        String nombreArchivo = sc.nextLine();

        // Instancio el objeto del fichero del usuario
        File ficheroUsuario = new File(nombreArchivo);

        // Compruebo si existe y sino lo creo
        if(ficheroUsuario.exists())
            System.out.println("El fichero ya existia");
        else
            ficheroUsuario.createNewFile();

        // Otro opción para crear y comprobar
        if(ficheroUsuario.createNewFile()){
            System.out.println("Fichero creado");
        }else{
            System.out.println("Ya existia");
        }

        System.out.println("Fin del programa");




    }
}
