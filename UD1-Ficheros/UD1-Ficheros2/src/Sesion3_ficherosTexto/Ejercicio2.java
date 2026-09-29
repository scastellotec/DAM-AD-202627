package Sesion3_ficherosTexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    /*
    Clase que busque una vocal en un fichero y muestre cuántas veces aparece.
     Trata las mayúsculas y minúsculas como el mismo carácter.
    * */
    public static void main(String[] args) {
        try {
            //1. Abrir un fichero
            FileReader fReader = new FileReader("libro.txt");
            // Contador para llevar la cuenta del nº de veces
            int contador = 0;
            // Vocal que tengo que buscar (debe estar en minuscula)
            char vocalBuscada = 'a';

            //2. Recorrer caracter a caracter ese fichero
                // Cuento las veces que aparece la vocal
            int letra;
            while((letra = fReader.read())!=-1){
                // La letras leida la pasa a minusculas
                if(vocalBuscada == Character.toLowerCase(letra))
                    contador++;
            }

            //4. Cierro recursos y muestro resultado
            fReader.close();

            System.out.println("El resultado es: "+contador+" "+vocalBuscada+"s");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
