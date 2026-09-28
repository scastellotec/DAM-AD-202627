package Sesion3_ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
    /*Clase que cree n ficheros llamados nombre1.txt … nombreN.txt
    , cada uno con el texto «Este es el fichero nombreN.txt».
     */
    public static void main(String[] args) throws IOException {

        // 1. Saber cuantos ficheros tengo que crear
        int numeroFicheros = 5;

        // 2. Repetir tantas veces como ficheros necesito
        for(int i=0; i<numeroFicheros; i++){
            // Creo el fichero
            FileWriter fWriter = new FileWriter("nombre"+i+".txt");
            // Escribo su contenido
            fWriter.write("Este es fichero numero"+i);
            // Cierro el fichero
            fWriter.close();
        }
    }
}
