package Sesion3_ficherosTexto;

import java.io.*;

public class Ejercicio5 {

    /*
    Crea un método que reciba el nombre de un fichero y un entero n,
     y escriba n líneas con el texto «Esta es la línea n»,
    Usa BufferedWriter y el método newLine() para los saltos de línea.
     Después abre el fichero generado con un editor y comprueba
      que las líneas están bien separadas.
     */
    public static void main(String[] args) {
        // Invoco al metodo
        escribrFichero("ejercio5.txt", 100);
    }


    public static void escribrFichero(String nombreFichero, int numLineas){
        try {
            // Abrir el fichero con stream que sea
            BufferedWriter wr = new BufferedWriter(
                    new FileWriter(nombreFichero));

            // Recorro y escribo
            for(int i=0; i<numLineas; i++){
                wr.write("esta es la linea "+i);
                wr.newLine();
            }

            // Libero recursos
            wr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Escribir lo que me piden en bucle

        // Cerrar recursos


    }
}
