package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EquipoRepositoryCSV {

    private final String nombreFichero = "equipos.csv";

    public void save(Equipo e) throws IOException {
            // Cargamos todo el csv
            ArrayList<Equipo> equipos = cargarCSV();
            // Añadimos nuestro equipo
            equipos.add(e);
            // Guardamos en CSV
            guardarCSV(equipos);
    }
    public Equipo findById(int id) throws IOException {
        Equipo equipoEncontrado = new Equipo();
            // Cargo el CSV
            ArrayList<Equipo> equipos = cargarCSV();
            // Busco el equipo en concreto
            for (Equipo equipo : equipos) {
                if(equipo.getId() == id) {
                    equipoEncontrado = equipo;
                    // Devuelvo el equipo encontrado
                    return equipoEncontrado;
                }
            }
        // No hemos encontrado equipo
        return null;
    }

    public ArrayList<Equipo> findAll() throws IOException {
        return cargarCSV();
    }

    public void deleteById(int id) throws IOException {
        // Cargo el CSV
        ArrayList<Equipo> equipos = cargarCSV();
        // Borro el equipo que no quiero
        for (Equipo equipo : equipos) {
            if(equipo.getId() == id){
                equipos.remove(equipo);
                break;
            }
        }
        // Guardo el CSV
        guardarCSV(equipos);
    }

    private ArrayList<Equipo> cargarCSV() throws IOException {
        // Abro el fichero
        Scanner sc = new Scanner(new File(nombreFichero));

        // Cargo todo en el arrayList y lo devuelvo
        ArrayList<Equipo> equiposCargados = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] lineaLeida = sc.nextLine().split(",");
            equiposCargados.add(new Equipo(
                    Integer.parseInt(lineaLeida[0]),
                    lineaLeida[1],
                    Integer.parseInt(lineaLeida[2])
            ));
        }
        sc.close();
        return equiposCargados;
    }
    private void guardarCSV(ArrayList<Equipo> equipos) throws IOException {
        // Abro el CSV (que se borre lo que hubiera)
        PrintWriter pw = new PrintWriter(new FileWriter(new File(nombreFichero), false));
        // Recorro el ArrayList y voy escribiendo en fichero
        for (Equipo equipo : equipos) {
            pw.println(equipo);
        }
        // Libero recursos
        pw.close();
    }
}
