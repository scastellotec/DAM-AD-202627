package Sesion3_ficherosTexto;
/*
* método  reciba  nombre fichero devuelva cuántas palabras.
* BufferedReader para leer línea a línea y split()
prueba :
una línea vacía en medio,
una línea que empiece con espacios,
dos palabras separadas por varios espacios seguidos.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            int numPalabras = cuentaPalabrasFichero("ejercicio6.txt");
            System.out.println("Palabras encontradas: "+numPalabras);
        } catch (FileNotFoundException e) {
            System.out.println("Ha sucedido un error. Vuelve a intentarlo");
        } catch (IOException e) {
            System.out.println("Ha sucedido un error. Vuelve a intentarlo");
        }
    }

    public static int cuentaPalabrasFichero(String nombreFichero) throws IOException {

        // Abrir el fichero
        BufferedReader bReader = new BufferedReader(
                                        new FileReader(nombreFichero));

        // Recorrerlo para contar palabras
        int contador =0;
        String linea = "";

        while((linea = bReader.readLine()) != null){
            if(!linea.isEmpty()){
                // Separo las palabras de la linea leido en un Array
                linea = linea.trim();
                String[] palabrasLinea = linea.split("\\s+");
                contador += palabrasLinea.length;
                System.out.println("Palabras contadas en esta linea: "+palabrasLinea.length);
            }
        }

        // Devolver resultado
        return contador;
    }
}
