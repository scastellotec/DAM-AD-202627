package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorRepositoryCSV {

    private final String nombreFichero = "jugadores.csv";

    public void save(Jugador j) throws IOException {

    }
    public Jugador findById(int dorsal) throws IOException {

        return new Jugador(1,"a");
    }

    public ArrayList<Jugador> findAll() throws IOException {

    }

    public void deleteById(int dorsal) throws IOException {

    }

    public void cambiarEquipo (int dorsal, Equipo nuevoEquipo){

    }

    private ArrayList<Jugador> cargarCSV() throws IOException {

    }
    private void guardarCSV(ArrayList<Jugador> jugadores) throws IOException {

    }
}
