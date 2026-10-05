package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio62_CSV {

      public static void main(String[] args) throws FileNotFoundException {
        // Leer CSV
          ArrayList<Alumno> alumnos = cargar("alumnos.csv");
          // Recorrer el ArrayList para ver que se guardan bien

          // Volver a guardar en un fichero
    }

    static ArrayList<Alumno> cargar(String nombreFichero) throws FileNotFoundException {
        ArrayList<Alumno> alumnosMemoria = new ArrayList<>();

        // Abro el fichero
        Scanner sc = new Scanner(new File(nombreFichero));

        // Leo la primera linea que son los titulos
        String lineaTitulos = sc.nextLine();
        System.out.println(lineaTitulos);

        // Recorrer fichero e ir cargando alumnos en memoria
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] datosLineaSeperados = linea.split(",");
            Alumno a = new Alumno(Integer.parseInt(datosLineaSeperados[0]),
                    datosLineaSeperados[1],
                    datosLineaSeperados[2]);
            alumnosMemoria.add(a);
        }


        return alumnosMemoria;
    }

    static void guardar(ArrayList<Alumno> alus, String nombreFichero ){

    }
}
