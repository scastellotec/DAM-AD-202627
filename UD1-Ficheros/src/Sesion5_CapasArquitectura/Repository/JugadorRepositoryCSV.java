package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorRepositoryCSV {

    private final String nombreFichero = "jugadores.csv";

    public void save(Jugador j) throws IOException {
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        // Añado el jugador
        jugadoresCargados.add(j);
        // Grabo el CSV
        guardarCSV(jugadoresCargados);
    }
    public Jugador findById(int dorsal) throws IOException {
        Jugador jEncontrado = new Jugador();
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        // Busco el jugador en concreto
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal)
                jEncontrado = j;
        }
        return jEncontrado;
    }

    public ArrayList<Jugador> findAll() throws IOException {
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        return jugadoresCargados;
    }

    public ArrayList<Jugador> jugadoresDelEquipo(int idEquipo) throws IOException {
        // Array que vais  devolver
        ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();

        for (Jugador j: jugadoresCargados) {
            if(j.getEquipo() == idEquipo)
                jugadoresEquipo.add(j);
        }

        return jugadoresEquipo;
    }

    public void deleteById(int dorsal) throws IOException {
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        // Borro el equipo que no quiero
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal)
                jugadoresCargados.remove(j);
        }
        // Guardo el CSV
        guardarCSV(jugadoresCargados);
    }

    public void cambiarEquipo (int dorsal, int nuevoEquipo) throws IOException {
        // Cargo el CSV
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        // Borro el equipo que no quiero
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal){
                j.setEquipo(nuevoEquipo);
                // ¿Queda actualizado en el ArrayList directamente?
            }
        }
        // Guardo el CSV
        guardarCSV(jugadoresCargados);
    }

    private ArrayList<Jugador> cargarCSV() throws IOException {
        // Abro el fichero
        Scanner sc = new Scanner(new File(nombreFichero));

        // Cargo todo en el arrayList y lo devuelvo
        ArrayList<Jugador> jugadoresCargados = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] lineaLeida = sc.nextLine().split(",");
            jugadoresCargados.add(new Jugador(
                    Integer.parseInt(lineaLeida[0]),
                    lineaLeida[1],
                    Integer.parseInt(lineaLeida[2])
            ));
        }
        sc.close();
        return jugadoresCargados;
    }

    private void guardarCSV(ArrayList<Jugador> jugadores) throws IOException {
            // Abro el CSV (que se borre lo que hubiera)
            PrintWriter pw = new PrintWriter(new FileWriter(new File(nombreFichero), false));
            // Recorro el ArrayList y voy escribiendo en fichero
            for (Jugador j : jugadores) {
                pw.println(j);
            }
            // Libero recursos
            pw.close();
    }

}
