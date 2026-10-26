package Sesion6_Binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio42_binario {
    public static void main(String[] args) throws IOException {

        // Leemos el archivo
        DataInputStream in = new DataInputStream(new FileInputStream("datos.dat"));

        // 2 - Leemos el dato
        float numero = in.readFloat();

        // 3 - Mostramos por pantalla
        System.out.println("El numero leido es: "+numero);


        // Cerramos el archivo
        in.close();
    }
}
