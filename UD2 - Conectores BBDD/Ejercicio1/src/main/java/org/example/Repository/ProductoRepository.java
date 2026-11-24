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
        // Lo que devolveré al usuario
        Producto producto;

        // Consulta que quiero realizar
        String consulta = "SELECT id, nombre, precio, descripcion FROM producto WHERE id = ?";

        // Me conecto a la BBDD
        try(Connection con = ConexionBD.getConexionBD()){

            // Preparo la consulta SQL
            PreparedStatement ps = con.prepareStatement(consulta);
            // Inicializo valor para preventir SQLInyection
            ps.setInt(1, id);

            // Ejecuto la consulta SQL
            ResultSet resultado = ps.executeQuery();

            // Como solo espero uno, no itero por el resultado.
            // Cojo el primer resultado. Es obligatorio hacer en next()
            resultado.next();

            // Mapeo la fila con el objeto Producto
            producto = new Producto(
                      resultado.getInt("id")
                    , resultado.getString("nombre")
                    , resultado.getBigDecimal("precio")
                    , resultado.getString("descripcion"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }
    public List<Producto> findByNombre(String texto) {

        List<Producto> productosEncontrados = new ArrayList<>();

        //1. Conectarme a la BBDD
        try(Connection con = ConexionBD.getConexionBD()) {
            //2. Preparar el SQL que quiero ejecutar
            String consulta = "SELECT id, nombre, precio, descripcion FROM producto WHERE nombre LIKE ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, texto);

            //3. Ejecuto y recogo el resultado
            ResultSet resultado = ps.executeQuery();

            //4. Devolvemos lo que haga falta
            while(resultado.next()){
                productosEncontrados.add(
                        new Producto(
                                resultado.getInt("id"),
                                resultado.getString("nombre"),
                                resultado.getBigDecimal("precio"),
                                resultado.getString("descripcion")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productosEncontrados;
    }

}
