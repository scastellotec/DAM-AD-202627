package Sesion9_xml;

import java.util.ArrayList;

public class Ejercicio42_contactos {


    public static void main(String[] args) {

        // Creo el arrayList
        ArrayList<Contacto> contactos = new ArrayList<>();

        // Añado unos cuantos contactos
        contactos.add(new Contacto(1, "Julian"));
        contactos.add(new Contacto(2, "Maria"));
        contactos.add(new Contacto(3, "John"));
        contactos.add(new Contacto(4, "Amanda"));
        contactos.add(new Contacto(5, "Jose"));

        //Generar un archivo XML con estos contactos
        /*
        * <agenda>
                <contacto id="xxx">
                    <nombre>xxxxx</nombre>
                </contacto>
        * */


        // Leer el mismo archivo XML e imprimir por pantalla toda la informacion




    }
}

