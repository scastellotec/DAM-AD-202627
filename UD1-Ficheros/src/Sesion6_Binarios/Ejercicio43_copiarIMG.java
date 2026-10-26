package Sesion6_Binarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio43_copiarIMG {

    public static void main(String[] args) throws IOException {

        // abrir el fichero de origen
        FileInputStream in = new FileInputStream("fotogrande.jpg");

        // abrir el fichero de destino
        FileOutputStream out = new FileOutputStream("copia.jpg");

        // Tomamos medida del tiempo ante de empezar a copiar
        long t1 = System.nanoTime();

        // ir leyendo byte a byte en origen
        // guardar byte a byte en destino
        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }

        // Tomamos el tiemp odespues de copiar
        long tiempoConBuffer = (System.nanoTime() - t1) / 1_000_000;

        // Imprimimos la diferencia
        System.out.println("Tiempo: "+tiempoConBuffer);

        // cierro y libero
        in.close();
        out.close();

    }
}
