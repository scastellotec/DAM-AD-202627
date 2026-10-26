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
 * Capa Repository: es la UNICA clase que sabe como se guardan los jugadores.
 *
 * Formato del fichero (una linea por jugador, sin cabecera):
 *     dorsal,nombre,idEquipo
 *
 * No valida nada y no imprime nada por pantalla: de eso se encarga el servicio.
 */
public class RepositorioJugadorCsv {

    private final Path fichero;

    public RepositorioJugadorCsv(Path fichero) {
        this.fichero = fichero;
    }

    // ------------------------------------------------------------
    //  Metodos privados: los unicos que tocan el fichero
    // ------------------------------------------------------------

    private List<Jugador> cargar() throws IOException {
        List<Jugador> lista = new ArrayList<>();

        // si el fichero no existe todavia, simplemente no hay datos
        if (!Files.exists(fichero)) return lista;

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;

                String[] campos = linea.split(",");
                lista.add(new Jugador(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])));
            }
        }
        return lista;
    }

    private void guardar(List<Jugador> lista) throws IOException {
        // OJO: no usamos pw.println(jugador) porque el toString()
        // no tiene el mismo formato que el fichero
        try (PrintWriter pw = new PrintWriter(fichero.toFile())) {
            for (Jugador j : lista) {
                pw.println(j.getDorsal() + "," + j.getNombre() + "," + j.getIdEquipo());
            }
        }
    }

    // ------------------------------------------------------------
    //  Metodos publicos: las operaciones del repositorio
    // ------------------------------------------------------------

    public List<Jugador> buscarTodos() throws IOException {
        return cargar();
    }

    /** Devuelve el jugador con ese dorsal, o null si no existe. */
    public Jugador buscarPorId(int dorsal) throws IOException {
        for (Jugador j : cargar()) {
            if (j.getDorsal() == dorsal) return j;
        }
        return null;
    }

    public void insertar(Jugador jugador) throws IOException {
        List<Jugador> lista = cargar();
        lista.add(jugador);
        guardar(lista);
    }

    /** Devuelve true si habia un jugador con ese dorsal y se ha sustituido. */
    public boolean actualizar(Jugador jugador) throws IOException {
        List<Jugador> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDorsal() == jugador.getDorsal()) {
                lista.set(i, jugador);
                guardar(lista);
                return true;
            }
        }
        return false;
    }

    /** Devuelve true si habia un jugador con ese dorsal y se ha borrado. */
    public boolean eliminar(int dorsal) throws IOException {
        List<Jugador> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDorsal() == dorsal) {
                lista.remove(i);
                guardar(lista);
                return true;
            }
        }
        return false;
    }
}
