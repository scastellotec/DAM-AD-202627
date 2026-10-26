package Sesion5_CapasArquitectura.liga.modelo;
/**
 * Representa a un jugador de la liga.
 *
 * El dorsal hace de identificador: no hay un campo id aparte.
 * La relacion con el equipo se guarda con el id del equipo (clave ajena).
 */
public class Jugador {

    private int dorsal;
    private String nombre;
    private int idEquipo;

    public Jugador() { }

    public Jugador(int dorsal, String nombre, int idEquipo) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.idEquipo = idEquipo;
    }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    @Override
    public String toString() {
        return dorsal + ", " + nombre + ", equipo=" + idEquipo;
    }
}
