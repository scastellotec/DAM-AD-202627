package org.example;

import org.example.Model.Producto;
import org.example.Repository.ProductoRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            ProductoRepository pRepo = new ProductoRepository();

            // Buscar todos
            List<Producto> productosDevueltos = pRepo.findAll();
            for (Producto p: productosDevueltos) {
                System.out.println(p.toString());
            }
            //pRepo.findAll().forEach(System.out::println);

            // Buscar uno dado
            //pRepo.findById(1);

            // Buscar por nombre
            //pRepo.findByNombre("teclado");


    }
}