import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        GestorPaises gp = new GestorPaises();

        // Ejercicio 1: Leer desde un CSV
        gp.leerCSV("paises.csv");

        // Ejercicio 2: Leer desde un Aleatorio
        gp.leerAleatorio("paises.dat",6);
        gp.leerAleatorio("paises.dat",7);
        gp.leerAleatorio("paises.dat",8);
        gp.leerAleatorio("paises.dat",9);
        gp.leerAleatorio("paises.dat",10);

        // Comprobación ejercicios 1 y 2. Deben de aparecer 10 paises
        gp.mostrarPaises();

        // Ejercicio 3: Escribir información de memoria a XML
        gp.escribeXML("paises.xml");
    }
}
