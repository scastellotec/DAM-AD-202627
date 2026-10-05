package Sesion4_PrintWriterScanner_CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Ejercicio61_bis {
    public static void main(String[] args) {

        // Donde guardo los numero en memoria
        ArrayList<Integer> numeros = new ArrayList<>();

        try {
            // abro el fichero para leer
            Scanner sc = new Scanner(new File("media.txt"));

            // cargo en memoria todos los numeros
            while(sc.hasNextLine()){
                try {
                    int numeroAuxiliar = Integer.valueOf(sc.nextLine());
                    numeros.add(numeroAuxiliar);
                }catch (Exception e){
                    System.out.println("He leido algo raro");
                }
            }

            // Como he terminado de leer => Libero recursos
            sc.close();

            //Calculo la media
            OptionalDouble media = numeros.stream()
                    .mapToInt(x -> x.intValue())
                    .average();

            // Abro el fichero para escribir
            PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"));

            // Escribo el resultado
            if(media.isPresent())
                pw.printf("Media: %.2f%n", media.toString());

            // Libero y cierro recursos
            pw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
