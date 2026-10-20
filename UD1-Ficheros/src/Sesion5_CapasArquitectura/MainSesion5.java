package Sesion5_CapasArquitectura;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;
//import Sesion5_CapasArquitectura.Service.EquipoService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSesion5 {
    public static void main(String[] args) throws IOException {
/*
        // IDEA: Borrar los archivos CSV y crearlos nuevos
        File fJugadores = new File("jugadores.csv");
        fJugadores.delete();
        fJugadores.createNewFile();
        File fEquipos = new File("equipos.csv");
        fEquipos.delete();
        fEquipos.createNewFile();


        EquipoService eService = new EquipoService();

        // Creo los equipos
        eService.creaEquipo(new Equipo(1, "Los buenos", 100));
        eService.creaEquipo(new Equipo(2, "Los regulares", 50));
        eService.creaEquipo(new Equipo(3, "Los malos", 10));

        // Busco un equipo
        System.out.println("### Busco el equipo id 3 ###");
        System.out.println(eService.encuentraEquipo(3));

        // Borro un equipo
        eService.borraEquipo(3);

        // Listo los equipos
        System.out.println("### Listo todos los equipos ###");
        for (Equipo e : eService.listarEquipos()) {
            System.out.println(e);
        }

        // Creo 3 jugadores
        eService.creaJugador(new Jugador(2, "Sergio", 1));
        eService.creaJugador(new Jugador(7, "jpg7", 1));
        eService.creaJugador(new Jugador(10, "Maria", 2));

        // Listo jugadores
        System.out.println("### Todos los jugadores###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }

        // Cambio de equipo
        eService.cambiaDeEquipo(7, 2);

        // Listo jugadores
        System.out.println("### Todos los jugadores despues de cambioEquipo ###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }

        // Borro un jugador
        //eService.borraJugador(7);

        // Listo jugadores
        System.out.println("### Todos los jugadores despues de borrado ###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }*/
    }
}
