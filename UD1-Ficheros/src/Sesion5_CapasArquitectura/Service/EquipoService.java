package Sesion5_CapasArquitectura.Service;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;
import Sesion5_CapasArquitectura.Repository.EquipoRepositoryCSV;
import Sesion5_CapasArquitectura.Repository.JugadorRepositoryCSV;

import java.io.IOException;
import java.util.ArrayList;

public class EquipoService {

    private EquipoRepositoryCSV equipoRepository = new EquipoRepositoryCSV();
    private JugadorRepositoryCSV jugadorRepository = new JugadorRepositoryCSV();

    public void creaEquipo(Equipo e) throws IOException {
        equipoRepository.save(e);
    }

    public ArrayList<Equipo> listarEquipos() throws IOException {
        return equipoRepository.findAll();
    }

    public Equipo encuentraEquipo(int id) throws IOException {
        return equipoRepository.findById(id);
    }

    public void borraEquipo(int id) throws IOException {
        equipoRepository.deleteById(id);
    }

    public void creaJugador(Jugador j){
        jugadorRepository.save(j);
    }

    public ArrayList<Jugador> listajugadoresEquipo(int idEquipo){
        //jugadorRepository.findAll()
        // filtro y devuelvo solo los del equipo que corersponda
    }

    //cambiaDeEquipo();
    //borraJugador();


}
