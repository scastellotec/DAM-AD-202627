package org.example.Repository;

import org.example.ConexionBD;
import org.example.Model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    public List<Producto> findAll(){
        // Lista que devolveré al usuario
        List<Producto> productosEncontrados = new ArrayList<>();
        // Consulta que quiero realizar
        String consulta = "SELECT id, nombre, precio, descripcion FROM producto";

        // Me conecto a la BBDD
        try(Connection con = ConexionBD.getConexionBD()){

            // Preparo la consulta SQL
            PreparedStatement ps = con.prepareStatement(consulta);
            // Ejecuto la consulta SQL
            ResultSet resultado = ps.executeQuery();
            // Itero por el resultado que me han dado
            while(resultado.next()){
                // Mapeo la fila con el objeto Producto
                Producto p =new Producto(resultado.getInt("id")
                , resultado.getString("nombre")
                , resultado.getBigDecimal("precio")
                , resultado.getString("descripcion"));

                // Lo añado al arrayList para devolverlo
                productosEncontrados.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productosEncontrados;
    }
    public Producto findById(int id){
        return null;
    }
    public List<Producto> findByNombre(String texto) {

        return null;
    }

}
