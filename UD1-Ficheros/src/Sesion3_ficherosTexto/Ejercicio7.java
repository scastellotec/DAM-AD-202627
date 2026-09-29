package Sesion3_ficherosTexto;

import java.io.*;

/*
* reciba dos ficheros de texto y genere un tercero contenido
el fichero de destino debe abrirse una sola vez.
*/
public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            combinaFicheros("f1.txt", "f2.txt");
        } catch (IOException e) {
            System.out.println("Algo salio mal");
        }
    }

    public static void combinaFicheros(String f1, String f2) throws IOException {

        // Abrir el fichero de escritura
        BufferedWriter bWriter = new BufferedWriter(
                                new FileWriter("ejercicio7.txt"));

        // Abrir el fichero f1 de lectura
        BufferedReader bReader = new BufferedReader(
                                new FileReader(f1));

        // Ir pasando las lineas resultado
        String linea = "";
        while((linea = bReader.readLine()) != null){
            bWriter.write(linea);
            bWriter.newLine();
        }

        // Cierro el f1
        bReader.close();

        // Abro el f2
        bReader = new BufferedReader(new FileReader(f2));

        // Ir pasando las lineas resultado
        linea = "";
        while((linea = bReader.readLine()) != null){
            bWriter.write(linea);
            bWriter.newLine();
        }

        // Libero recursos
        bReader.close();
        bWriter.close();


    }
}
