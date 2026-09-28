package Sesion3_ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    /*
    * Programa que pida frases por teclado hasta que se
    * escriba «fin» y las guarde en un fichero.
    * Después, muestra el contenido del fichero frase por frase.
     */
    public static void main(String[] args) throws IOException {

        // Bucle donde recojo frase del usuario
        String fraseUsuario = "";

        // Archivo donde guardo las cosas
        FileWriter fWriter = new FileWriter("memoriasUsuario.txt", true);

        // Recojo la primera frase del usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe frases para guardar: ");
        fraseUsuario = sc.nextLine();

        while(!fraseUsuario.toLowerCase().equals("fin")){
            // Guardo la frase en el fichero \n => Salto de linea
            fWriter.write(fraseUsuario+"\n");
            // Recojo la siguiente frase
            fraseUsuario = sc.nextLine();
        }

        // Libero recursos
        sc.close();
        fWriter.close();

    }
}
