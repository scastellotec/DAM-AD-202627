package Sesion2_Excepciones;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio1 {

    // 3.1 Recupera el ejercicio de borrar un fichero. Tenías la versión
    // con File.delete(),
    // que devuelve boolean. Escribe ahora la versión con Files.delete()
    // distinguiendo en el catch el caso de que no exista del resto de errores.
    public static void main(String[] args) {

        try {
            // Lo hago con la version java.nio que lanza excepciones
            Path ruta = Path.of("");

            // Borro el fichero
            Files.delete(ruta);

        } catch (NoSuchFileException e) {
            System.out.println("El fichero no existe");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("La carpeta que quieres borrar no esta vacia");
        } catch (IOException e) {
            System.out.println("Error. No se puedo borrar el elemento: "+e.getMessage());
        }


    }
}
