package Sesion8_randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio42_Agenda {

    // Caclulo del tamaño del registro
    static final int TAM_ID = 4;
    static final int TAM_NOMBRE = 3;
    static final int TAM_REGISTRO = TAM_ID + TAM_NOMBRE*2;
    static final String NOMBRE_FICHERO = "agenda.dat";

    public static void main(String[] args) throws IOException {

        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")){
            raf.setLength(0); // Borro el fichero al comienzo

            System.out.println("## Escribo unos contactos");
            // escrbio varios registros
            escribir(1, "ana");
            escribir(2, "edu");
            escribir(3, "eva");
            escribir(6, "leo");

            System.out.println("## Leo unos contactos");
            // leemos los registros
            leer(1);
            leer(2);
            leer(3);
            leer(6);

            System.out.println("## Modifico el nombre");
            // cambiamos un nombre
            cambiarNombre(3, "ali");

            System.out.println("## Vuelvo a leer ese contacto");
            // Leemos el registro
            leer(3);

            System.out.println("## Tamaño del archivo: "+raf.length());
        }

    }

    static void escribir(int id, String nombre) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {

            // Me posiciono en el sitio a escribir
            raf.seek(id*TAM_REGISTRO);

            // Escribo el ID y el nombre
            raf.writeInt(id);
            raf.writeChars(nombre);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void leer(int id) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {

            // Me posiciono en el sitio a leer
            raf.seek(id*TAM_REGISTRO);

            // Leo el ID
            System.out.println("Datos del registro leido: ");
            System.out.println(" - ID: "+raf.readInt());

            // Leo el nombre
            String nombreLeido = "";
            for (int i = 0; i < TAM_NOMBRE; i++) {
                nombreLeido += raf.readChar();
            }
            System.out.println(" - Nombre: " + nombreLeido);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void cambiarNombre(int id, String nuevoNombre) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {

            // Me posiciono en el sitio a escribir
            raf.seek(id*TAM_REGISTRO+TAM_ID);

            // Ecribo el nuevo nombre
            raf.writeChars(nuevoNombre);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
