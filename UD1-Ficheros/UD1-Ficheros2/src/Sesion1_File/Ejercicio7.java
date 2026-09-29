package Sesion1_File;

import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Dado un directorio, muestra el nombre de todo lo que contiene,
        //  distinguiendo ficheros de carpetas, o indica que está vacío.

        // Instanciamos el directorio
        File directorio = new File("datos2");

        // TODO: Comprobar que es un directorio

        // Version 1: Utilizando list() que devuelve un String[]
        System.out.println("Version 1 - usando list()");

        // Miramos si tiene contenido
        String[] contenido = directorio.list();

        // Comprobamos que contenido no es nulo
        if(contenido == null){
            System.out.println("Directorio vacio");
        }

        // Forma primitiva de recorrer un array
        for(int i=0; i<contenido.length; i++){
            System.out.println(contenido[i]);
        }

        // Otra forma de recorrer el array
        for (String s: contenido) {
            System.out.println(s);
        }

        // Esta version 1 no me vale porque no me permite distinguir entre archivos y carpetas

        // Version 2: Utilizando listFiles() que devuelve un File[]
        System.out.println("Version 2 - usando File()");

        File[] contenido2 = directorio.listFiles();

        for (File f: contenido2) {
            // forma 1: mas clasica
            /*if(f.isDirectory())
                System.out.println("[Carpeta] "+f.getName());
            else
                System.out.println("- "+f.getName());*/

            // Forma 2: con if ternario
            System.out.println(f.isDirectory() ? "[Carpeta] "+f.getName(): "- "+f.getName());
        }


    }
}
