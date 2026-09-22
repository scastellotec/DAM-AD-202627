package Sesion1_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio8_nio {
    public static void main(String[] args) {
        // Lista todo el contenido de una carpeta con Files.walk().

        // Instancio la ruta de la carpeta con Path
        Path ruta = Path.of("datos2");

        //try-cath con recursos -> se libera al finalizar
        try (Stream<Path> contenido = Files.walk(ruta);){
            // Recupero el contenido de la carpeta con Files.walk

            // Recorro el contenido y lo muestro
            contenido.forEach(System.out::println);

            contenido.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
