package Sesion8_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_demostracion {
    public static void main(String[] args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile("random.dat", "rw");

        // Genero un archivo aleatorio con los numeros del 0 al 9 incluidos
        for (int i = 0; i < 10; i++) {
            raf.writeInt(i);
        }

        //Composición bit a bit del fichero generado
        // Cada entero escrito ocupa 4 bytes
        //0-3:   (num=0) 00000000 00000000 00000000 00000000
        //4-7:   (num=1) 00000000 00000000 00000000 00000001
        //8-11:  (num=2) 00000000 00000000 00000000 00000010
        //12-15: (num=3) 00000000 00000000 00000000 00000011
        //16-19: (num=4) 00000000 00000000 00000000 00000100
        //20-23: (num=5) 00000000 00000000 00000000 00000101
        //24-27: (num=6) 00000000 00000000 00000000 00000110
        //28-31: (num=7) 00000000 00000000 00000000 00000111
        //32-35: (num=8) 00000000 00000000 00000000 00001000
        //36-39: (num=9) 00000000 00000000 00000000 00001001

        // Me posiciono en el byte 19
        raf.seek(20);

        int sexto = raf.readInt(); //19: 00000100 00000000 00000000 00000000
        System.out.println("El entero es: " + sexto);

        // Sobreescribir el numero 5
        raf.seek(20);
        raf.writeInt(255);

        // Me posiciono en el byte 20
        raf.seek(20);

        sexto = raf.readInt(); //19: 00000100 00000000 00000000 00000000
        System.out.println("El entero es: " + sexto);

        raf.close();

    }
}
