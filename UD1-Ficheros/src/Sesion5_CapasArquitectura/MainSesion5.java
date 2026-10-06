package Sesion5_CapasArquitectura;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Service.EquipoService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSesion5 {
    public static void main(String[] args) throws IOException {
        EquipoService eService = new EquipoService();

        // Creo los equipos
        eService.creaEquipo(new Equipo(1,"Los buenos",100));
        eService.creaEquipo(new Equipo(2,"Los regulares",50));
        eService.creaEquipo(new Equipo(3,"Los malos",10));

        // Busco un equipo
        System.out.println(eService.encuentraEquipo(3));

        // Borro un equipo
        eService.borraEquipo(2);

    }
}
