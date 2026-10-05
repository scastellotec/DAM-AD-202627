package Sesion4_PrintWriterScanner_CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio61 {
    public static void main(String[] args) {

        // Donde guardo los numero en memoria
        ArrayList<Integer> numeros = new ArrayList<>();
        int numerosSumados = 0;
        int cuantosNumerosHay = 0;

        try {
            // abro el fichero para leer
            Scanner sc = new Scanner(new File("media.txt"));

            // cargo en memoria todos los numeros
            while(sc.hasNextLine()){
                try {
                    int numeroAuxiliar = Integer.valueOf(sc.nextLine());
                    numerosSumados += numeroAuxiliar;
                    numeros.add(numeroAuxiliar);
                    System.out.println("Numero leido: "+numeroAuxiliar  );
                }catch (Exception e){
                    System.out.println("He leido algo raro");
                }
            }

            // Como he terminado de leer => Libero recursos
            sc.close();

            //Calculo la media
            cuantosNumerosHay = numeros.size();
            float resultado = numerosSumados / cuantosNumerosHay;

            // Abro el fichero para escribir
            PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"));

            // Escribo el resultado
            pw.printf("Media: %.2f%n", resultado);

            // Libero y cierro recursos
            pw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
