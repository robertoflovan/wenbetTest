/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Direccion;
import com.wenbet.wenbettest2.modelo.HoraTrabajada;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class TestModelo {
    
    public static void main(String[] args) {
       
        Direccion d1 = new Direccion("Salitllo", "Satelite norte", "Eros", "112");
        Direccion d2 = new Direccion("Salitllo2", "Satelite norte2", "Eros 2", "2");
        Direccion d3 = new Direccion("Salitllo3", "Satelite norte3", "Eros 3", "3");
        Direccion d4 = new Direccion("asd", "Satelite asd", "asd 3", "asd");
        
        LocalDate fecha1 = LocalDate.now();
        Trabajador trabajador1 = new Trabajador("Roberto Flores", "Gerente", "Comentario1", fecha1 , d1);
        Trabajador trabajador2 = new Trabajador("Wendy Vanegas", "Gerente", "Comentario dos", fecha1 , d2);
        
        TipoProducto tipoProducto1 = new TipoProducto("producto tipo 1");
        TipoProducto tipoProducto2 = new TipoProducto("producto tipo 2");
        
        Actividad actividad1 = new Actividad("Soldar");
        Actividad actividad2 = new Actividad("Pintar");
        Actividad actividad3 = new Actividad("Pulir");
        
        Cliente cliente1 = new Cliente("Sandy", "0", "555", "Comentario", d3);
        Cliente cliente2 = new Cliente("Juan", "0", "555", "Comentario", d4);
        
        Producto producto1 = new Producto("Proteccion", tipoProducto1);
        
        TrabajoProducto trabajoProducto = new TrabajoProducto(1, 50.0, producto1);
        
        List<TrabajoProducto> listaProductosTrabajo1 = new ArrayList<>();
        listaProductosTrabajo1.add(trabajoProducto);
        Trabajo trabajo1 = new Trabajo(fecha1, cliente2, listaProductosTrabajo1);
        
        HoraTrabajada ht1 = new HoraTrabajada("1:40", actividad1, trabajador2, trabajo1);
        HoraTrabajada ht2 = new HoraTrabajada("2:40", actividad2, trabajador2, trabajo1);
        HoraTrabajada ht3 = new HoraTrabajada("0:30", actividad3, trabajador1, trabajo1);
        
        System.out.println("prueba");
        
        
        
        
        
    }
    
}
