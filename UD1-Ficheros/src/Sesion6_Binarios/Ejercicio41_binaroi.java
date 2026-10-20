package Sesion6_Binarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio41_binaroi {
    public static void main(String[] args) throws IOException {

        // Abro el srteam para escribir en binario
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("datos.dat"));

        // Escribo los datos
        out.writeInt(7);
        out.writeDouble(3.14);
        out.writeBoolean(true);
        out.writeChars("Hola");

        // Cierro y libero recursos
        out.close();

    }
}
