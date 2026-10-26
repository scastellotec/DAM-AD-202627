package Sesion5_CapasArquitectura.liga;

import Sesion5_CapasArquitectura.liga.repositorio.*;
import Sesion5_CapasArquitectura.liga.modelo.*;
import Sesion5_CapasArquitectura.liga.servicio.*;


import java.io.IOException;
import java.nio.file.Path;



public class Main {

    public static void main(String[] args) throws IOException {

        // Instancio repositorio jugadores y equipos
        RepositorioJugadorCsv repoJugadores = new RepositorioJugadorCsv(Path.of("jugadores.csv"));
        RepositorioEquipoCsv repoEquipos = new RepositorioEquipoCsv(Path.of("equipos.csv"));

        // Instancio el service con los repositorio elegidos
        LigaService liga = new LigaService(repoJugadores, repoEquipos);

        // --- 2. datos de prueba ---

        // se vacian primero para poder ejecutar el programa varias veces
        for (Equipo e : repoEquipos.buscarTodos()) repoEquipos.eliminar(e.getId());
        for (Jugador j : repoJugadores.buscarTodos()) repoJugadores.eliminar(j.getDorsal());

        repoEquipos.insertar(new Equipo(1, "Real Zaragoza", 0));
        repoEquipos.insertar(new Equipo(2, "SD Huesca", 0));

        liga.fichar(new Jugador(10, "Ana Ruiz", 0), 1);
        liga.fichar(new Jugador(1, "Luis Perez", 0), 1);
        liga.fichar(new Jugador(7, "Marta Gil", 0), 2);

        // --- 3. la comprobacion del ejercicio 6.4 ---
        System.out.println("=== La lista de jugadores ===");
        System.out.println("Desde el repositorio: " + repoEquipos.buscarPorId(1));

        Equipo equipo = liga.equipoConJugadores(1);
        System.out.println("Desde el servicio:    " + equipo);
        for (Jugador j : equipo.getJugadores()) {
            System.out.println("   " + j);
        }

        // --- 4. actualizar y eliminar ---
        System.out.println();
        System.out.println("=== Actualizar y eliminar ===");
        System.out.println("actualizar dorsal 7:  " + repoJugadores.actualizar(new Jugador(7, "Marta Gil Lopez", 2)));
        System.out.println("actualizar dorsal 99: " + repoJugadores.actualizar(new Jugador(99, "Nadie", 1)));
        System.out.println("eliminar dorsal 1:    " + repoJugadores.eliminar(1));
        System.out.println("eliminar dorsal 50:   " + repoJugadores.eliminar(50));

        // --- 5. puntos y clasificacion ---
        System.out.println();
        System.out.println("=== Puntos ===");
        liga.sumarPuntos(2, 3);      // gana el Huesca
        liga.sumarPuntos(1, 1);      // empata el Zaragoza

        System.out.println("Clasificacion:");
        for (Equipo e : liga.clasificacion()) {
            System.out.println("   " + e);
        }

        // --- 6. las reglas de negocio ---
        System.out.println();
        System.out.println("=== Reglas de negocio ===");
        probarRegla(liga, new Jugador(5, "", 0), 1);
        probarRegla(liga, new Jugador(150, "Pepe", 0), 1);
        probarRegla(liga, new Jugador(10, "Otro", 0), 1);
        probarRegla(liga, new Jugador(5, "Pepe", 0), 9);
    }

    /** Metodo auxiliar para ver los mensajes de las reglas sin parar el programa. */
    private static void probarRegla(LigaService liga, Jugador jugador, int idEquipo)
            throws IOException {
        try {
            liga.fichar(jugador, idEquipo);
            System.out.println("   fichado: " + jugador);
        } catch (IllegalArgumentException e) {
            System.out.println("   rechazado: " + e.getMessage());
        }
    }
}
