package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio5 {

    //5.5 Borra un fichero e informa del resultado. Repítelo con Files.delete() y
    // observa qué información adicional obtienes cuando falla.

    public static void main(String[] args) {
        // Version 1: Borramos el fichero con FIle
        // Instancio el fichero
        File f = new File("ejercicio3.txt");

        // Borro el fichero y evaluo el resultado
        if (f.delete()) {
            System.out.println("Borrado");
        } else {
            System.out.println("No se pudo borrar");   // ¿por qué? No lo sabemos
        }

        // Versión 2: utilizando java nio
        // Instancio el archivo con Path
        Path ruta = Path.of("datos1.txt");

        try {
            // Ejecuto el borrado con Files
            Files.delete(ruta);
            System.out.println("Borrado");
        } catch (NoSuchFileException e) {
            System.out.println("No existe: " + ruta.toAbsolutePath());
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Es un directorio con contenido");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
