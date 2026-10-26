package Sesion5_CapasArquitectura.liga.servicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Sesion5_CapasArquitectura.liga.repositorio.*;
import Sesion5_CapasArquitectura.liga.modelo.*;
import Sesion5_CapasArquitectura.liga.servicio.*;

/**
 * Capa Service: contiene la logica de negocio de la liga.
 *
 * Es quien decide que esta permitido y que no, y quien coordina
 * los dos repositorios cuando una operacion necesita los dos.
 *
 * Para las reglas de negocio se usa IllegalArgumentException,
 * nunca IOException: que un dorsal sea 150 no es un fallo de disco.
 */
public class LigaService {

    private final RepositorioJugadorCsv repoJugadores;
    private final RepositorioEquipoCsv repoEquipos;

    public LigaService(RepositorioJugadorCsv repoJugadores, RepositorioEquipoCsv repoEquipos) {
        this.repoJugadores = repoJugadores;
        this.repoEquipos = repoEquipos;
    }

    // ------------------------------------------------------------
    //  Fichar: aqui viven las reglas
    // ------------------------------------------------------------

    /**
     * Da de alta un jugador en un equipo.
     * Las comprobaciones van de la mas barata a la mas cara, y todas
     * ANTES de tocar el fichero: si falla alguna, no se guarda nada.
     */
    public void fichar(Jugador jugador, int idEquipo) throws IOException {

        if (jugador.getNombre() == null || jugador.getNombre().isBlank()) {
            throw new IllegalArgumentException("El jugador debe tener nombre");
        }

        if (jugador.getDorsal() < 1 || jugador.getDorsal() > 99) {
            throw new IllegalArgumentException("El dorsal debe estar entre 1 y 99");
        }

        if (repoJugadores.buscarPorId(jugador.getDorsal()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un jugador con el dorsal " + jugador.getDorsal());
        }

        if (repoEquipos.buscarPorId(idEquipo) == null) {
            throw new IllegalArgumentException("No existe el equipo " + idEquipo);
        }

        jugador.setIdEquipo(idEquipo);
        repoJugadores.insertar(jugador);
    }

    // ------------------------------------------------------------
    //  Consultas
    // ------------------------------------------------------------

    public List<Jugador> listarJugadores() throws IOException {
        return repoJugadores.buscarTodos();
    }

    public List<Equipo> listarEquipos() throws IOException {
        return repoEquipos.buscarTodos();
    }

    /**
     * Devuelve el equipo con su plantilla ya rellenada.
     *
     * El repositorio solo puede devolver lo que hay en su fichero
     * (id, nombre y puntos). La lista de jugadores se reconstruye aqui
     * recorriendo el fichero de jugadores y filtrando por equipo.
     */
    public Equipo equipoConJugadores(int id) throws IOException {

        Equipo equipo = repoEquipos.buscarPorId(id);
        if (equipo == null) return null;

        List<Jugador> suyos = new ArrayList<>();
        for (Jugador j : repoJugadores.buscarTodos()) {
            if (j.getIdEquipo() == id) {
                suyos.add(j);
            }
        }

        equipo.setJugadores(suyos);
        return equipo;
    }

    // ------------------------------------------------------------
    //  Puntos
    // ------------------------------------------------------------

    /**
     * Suma puntos a un equipo.
     *
     * Fijate en el patron, que se repite en cualquier modificacion:
     *     buscar el objeto -> cambiarlo en memoria -> guardarlo con actualizar()
     *
     * Si se olvida el tercer paso, el cambio se queda en memoria
     * y el fichero no se entera.
     */
    public void sumarPuntos(int idEquipo, int puntos) throws IOException {

        Equipo equipo = repoEquipos.buscarPorId(idEquipo);
        if (equipo == null) {
            throw new IllegalArgumentException("No existe el equipo " + idEquipo);
        }

        equipo.setPuntos(equipo.getPuntos() + puntos);
        repoEquipos.actualizar(equipo);
    }

    /** Devuelve los equipos ordenados de mas a menos puntos. */
    public List<Equipo> clasificacion() throws IOException {
        List<Equipo> equipos = repoEquipos.buscarTodos();
        equipos.sort((a, b) -> b.getPuntos() - a.getPuntos());
        return equipos;
    }
}
