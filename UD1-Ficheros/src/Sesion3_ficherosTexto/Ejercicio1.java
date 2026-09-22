package Sesion3_ficherosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            // 1. Abro el fichero
            FileReader fichero = new FileReader("datos1.txt");

            // 2. Leo el fichero
            int letra;
            while((letra = fichero.read()) != -1)
                System.out.print((char)letra);

            /* Equivalente
                int letra = fichero.read();
                while(letra != -1) {
                    System.out.print((char) letra);
                    letra = fichero.read();
                }
           */

            // 3. Libero recursos
            fichero.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
