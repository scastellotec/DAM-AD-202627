package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6Bis {
    public static void main(String[] args) throws IOException {
        int numPalabras = cuentaPalabrasFichero("ejercicio6.txt");
        System.out.println("Palabras encontradas: "+numPalabras);
    }

    public static int cuentaPalabrasFichero(String nombreFichero) throws IOException {

        // Abrir el fichero
        BufferedReader bReader = new BufferedReader(
                new FileReader(nombreFichero));

        // Recorrerlo para contar palabras
        int resultado = bReader.lines()
                            .filter(x -> !x.isEmpty())
                            .mapToInt(x -> x.split("\\s+").length)
                            .sum();

        System.out.println("Resultado: "+resultado);

        // Devolver resultado
        return resultado;
    }
}
