package Sesion5_CapasArquitectura.liga.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un equipo de la liga.
 *
 * Importante: la lista de jugadores NO se guarda en el fichero.
 * Es informacion derivada que el servicio calcula a partir del
 * fichero de jugadores. Los puntos, en cambio, si se guardan.
 */
public class Equipo {

    private int id;
    private String nombre;
    private int puntos;

    // se inicializa aqui para que nunca sea null
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo() { }

    public Equipo(int id, String nombre, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }

    @Override
    public String toString() {
        return id + ", " + nombre + ", " + puntos + " puntos, jugadores=" + jugadores.size();
    }
}
