package Sesion5_CapasArquitectura.liga.repositorio;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Sesion5_CapasArquitectura.liga.repositorio.*;
import Sesion5_CapasArquitectura.liga.modelo.*;
import Sesion5_CapasArquitectura.liga.servicio.*;

/**
 * Capa Repository: es la UNICA clase que sabe como se guardan los equipos.

 *
 * Formato del fichero (una linea por equipo, sin cabecera):
 *     id,nombre,puntos
 *
 * La lista de jugadores NO se guarda: es informacion derivada que
 * reconstruye el servicio a partir del fichero de jugadores.
 */
public class RepositorioEquipoCsv {

    private final Path fichero;

    public RepositorioEquipoCsv(Path fichero) {
        this.fichero = fichero;
    }

    // ------------------------------------------------------------
    //  Metodos privados: los unicos que tocan el fichero
    // ------------------------------------------------------------

    private List<Equipo> cargar() throws IOException {
        List<Equipo> lista = new ArrayList<>();

        if (!Files.exists(fichero)) return lista;

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;

                String[] campos = linea.split(",");
                lista.add(new Equipo(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])));   // se crea sin jugadores
            }
        }
        return lista;
    }

    private void guardar(List<Equipo> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(fichero.toFile())) {
            for (Equipo e : lista) {
                pw.println(e.getId() + "," + e.getNombre() + "," + e.getPuntos());
            }
        }
    }

    // ------------------------------------------------------------
    //  Metodos publicos
    // ------------------------------------------------------------

    public List<Equipo> buscarTodos() throws IOException {
        return cargar();
    }

    /** Devuelve el equipo con ese id, o null si no existe. */
    public Equipo buscarPorId(int id) throws IOException {
        for (Equipo e : cargar()) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void insertar(Equipo equipo) throws IOException {
        List<Equipo> lista = cargar();
        lista.add(equipo);
        guardar(lista);
    }

    public boolean actualizar(Equipo equipo) throws IOException {
        List<Equipo> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == equipo.getId()) {
                lista.set(i, equipo);
                guardar(lista);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) throws IOException {
        List<Equipo> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                guardar(lista);
                return true;
            }
        }
        return false;
    }
}
