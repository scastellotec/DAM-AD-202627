package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio62_CSV {

      public static void main(String[] args) throws FileNotFoundException {
          // Leer CSV
          ArrayList<Alumno> alumnos = cargar("alumnos.csv");

          // Recorrer el ArrayList para ver que se guardan bien
          /*for(int i=0; i<alumnos.size();i++ ){
              System.out.println(alumnos.get(i));
          }
          for (Alumno a: alumnos) {
              System.out.println(a);
          }*/
          alumnos.forEach(System.out::println);

          // Modificar algun alumno, o añadir alguno nuevo
          alumnos.add(new Alumno(3, "Julian","j@iespab.com"));
          alumnos.get(1).setNombre("Eustaquio");

          // Volver a guardar en un fichero
          guardar(alumnos, "alumnos2.csv");
    }

    static ArrayList<Alumno> cargar(String nombreFichero) throws FileNotFoundException {
        // El arraylist que devolvere al usuario
        ArrayList<Alumno> alumnosMemoria = new ArrayList<>();

        // Abro el fichero
        Scanner sc = new Scanner(new File(nombreFichero));

        // Leo la primera linea que son los titulos
        String lineaTitulos = sc.nextLine();

        // Recorrer fichero e ir cargando alumnos en memoria
        while(sc.hasNextLine()){
            // Leo una linea de un alumno del csv
            String linea = sc.nextLine();
            // Separo los datos con split basandome en la comas ","
            String[] datosLineaSeperados = linea.split(",");
            // Creo un alumno con el constructor y los datos leidos
            Alumno a = new Alumno(
                    Integer.parseInt(datosLineaSeperados[0]),
                    datosLineaSeperados[1],
                    datosLineaSeperados[2]);
            // Añado al arrayList que luego devolvere
            alumnosMemoria.add(a);
        }

        return alumnosMemoria;
    }

    static void guardar(ArrayList<Alumno> alus, String nombreFichero ) throws FileNotFoundException {
        // Abrir el fichero para escritura
        PrintWriter pw = new PrintWriter(new File(nombreFichero));

        // Escribo el título del CSV
        pw.println("id,nombre,email");
        // Recorro el arrayList y lo guardo
        for (Alumno a: alus) {
            pw.println(a);
        }
        // Version lambda: alus.forEach(a -> pw.println(a));

        // Cerrar el fichero
        pw.close();
    }

    static void modificarEmail(int id, String nuevoEmail){
        // Cargar el CSV
        //cargar()
        // Recorrer to do el arraylIST y buscar quien tiene ese id
            // Modificar el email del usuario
        //guardarCSV()
    }
}
