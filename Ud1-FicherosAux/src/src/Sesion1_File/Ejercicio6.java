package src.Sesion1_File;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        // 5.6 Borra un directorio.
        // Comprueba qué ocurre si no está vacío y explica por qué.

        // Instancio el directorio
        File d = new File("datos");

        // Compruebo si existe y si efectivamente es un directorio
        if (!d.exists())      {
            System.out.println("No existe");
            return; // Esta forma no es la correcta de salir del programa
        }
        if (!d.isDirectory()) {
            System.out.println("No es un directorio");
            return; // Esta forma no es la correcta de salir del programa
        }

        // Borro el directorio y evaluo el resultado
        if (d.delete()) {
            System.out.println("Directorio borrado");
        } else {
            System.out.println("No se pudo borrar (¿está vacío?)");
        }

    }
}
