package Sesion5_CapasArquitectura.Model;

public class Jugador {
     private int dorsal;
     private String nombre;

     private int equipo;

    public Jugador() {}
    public Jugador(int dorsal, String nombre, int equipo) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return dorsal + "," + nombre + "," + equipo;
    }
}
