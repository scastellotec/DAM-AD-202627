package src.Sesion1_File;

import java.io.File;
public class Ejercicio2 {
    public static void main(String[] args) {
        // 5.2 Lo mismo con un directorio. Comprueba con isDirectory()
        // que efectivamente lo es, y explica en un comentario qué devuelve length() sobre él.

        File f = new File("datos");

        if(f.isDirectory()){
            // Muestra la informacion
            System.out.println("Tamaño: "+f.length());
            // lenght() no devuelve el tamaño de la carpeta.
            // Primera teoria es que devuelve el tamaño reservado por el SO en memoria o disco.
        } else {
            System.out.println("Lo que has seleccionado no es un directorio");
        }


    }
}
