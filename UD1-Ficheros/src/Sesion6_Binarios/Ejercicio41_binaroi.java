package Sesion6_Binarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio41_binaroi {
    public static void main(String[] args) throws IOException {

        // ESCRIBIMOS EL ARCHIVO

        // Abro el srteam para escribir en binario
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("datos.dat"));

        // Escribo los datos
        out.writeInt(7);

        // Cierro y libero recursos
        out.close();

    }
}
