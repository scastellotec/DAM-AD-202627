package src.Sesion1_File;

import java.io.File;

public class Ejercicio4 {
    public static void main(String[] args) {
        //5.4 Crea una carpeta e informa de si se ha creado o ya existía.
        // Prueba con una ruta de varios niveles y comprueba la diferencia entre mkdir() y mkdirs().

        // Probando un solo directorio con mkdir
        File f = new File("datos2");
        if(f.mkdir())
            System.out.println("Directorio craedo");
        else
            System.out.println("Directorio no creado");

        // Probando varios directorios con mkdirs
        File f2 = new File("datos2/one/two/three");
        if(f2.mkdirs())
            System.out.println("Directorio creado");
        else
            System.out.println("Directorio no creado");


    }
}
