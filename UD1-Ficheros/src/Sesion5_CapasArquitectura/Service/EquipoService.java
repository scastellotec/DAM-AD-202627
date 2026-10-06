package Sesion5_CapasArquitectura.Service;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Repository.EquipoRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class EquipoService {

    private EquipoRepository equipoRepository = new EquipoRepository();

    public void creaEquipo(Equipo e) throws IOException {
        equipoRepository.save(e);
    }

    public ArrayList<Equipo> listarEquipos() throws FileNotFoundException {
        return equipoRepository.findAll();
    }

    public Equipo encuentraEquipo(int id) throws FileNotFoundException {
        return equipoRepository.findById(id);
    }

    public void borraEquipo(int id) throws IOException {
        equipoRepository.deleteById(id);
    }
}
