package Sesion1_File;

import java.io.File;

public class Ejercicio8 {
    public static void main(String[] args) {
        // 5.8 Lista recursivamente todo el contenido de una carpeta
        //  con su ruta. Resuélvelo dos veces: con listFiles()
        //  recursivo y con Files.walk().

        // Instancio la carpeta que deseo listar
        File carpeta = new File("datos2");

        // Llamamos al metodo recursivo pasandole la carpeta raiz
        listarContenido(carpeta);

        // listarContenido(new File("datos2"));
    }

    public static void listarContenido(File carpetaActual){
        // Listar de contenido
        File[] contenido = carpetaActual.listFiles();

        // Si la carpeta esta vacio o no
        if(contenido == null || contenido.length == 0) {
            System.out.println("No es un directorio o esta vacio");
        } else {
            // Recorro el contenido de la carpeta
            for (File f : contenido) {
                // Muestro el nombre del archivo o carpeta
                System.out.println(f.getPath());

                // Compruebo si es una subcarpeta y si lo es profundizo
                if(f.isDirectory())
                    listarContenido(f);
            }
        }

    }
}
