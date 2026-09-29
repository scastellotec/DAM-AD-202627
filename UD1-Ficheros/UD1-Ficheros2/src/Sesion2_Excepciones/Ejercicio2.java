package Sesion2_Excepciones;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio2 {
    public static void main(String[] args) {

        Path ruta = Path.of("datos");
        try {
            Files.delete(ruta);
            System.out.println("Directorio borrado");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("El directorio no está vacío."+ruta.toAbsolutePath());
        } catch (NoSuchFileException e) {
            System.out.println("No existe el directorio: " + ruta.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("No se pudo borrar: " + e.getMessage());
        }
    }
}
