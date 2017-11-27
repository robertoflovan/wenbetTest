/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Direccion;
import com.wenbet.wenbettest2.modelo.HoraTrabajada;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import com.wenbet.wenbettest2.service.ActividadService;
import com.wenbet.wenbettest2.service.ClienteService;
import com.wenbet.wenbettest2.service.DireccionService;
import com.wenbet.wenbettest2.service.HoraTrabajadaService;
import com.wenbet.wenbettest2.service.ProductoService;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.service.TrabajadorService;
import com.wenbet.wenbettest2.service.TrabajoProductoService;
import com.wenbet.wenbettest2.service.TrabajoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto
 */
public class TestHoraTrabajada {
    
    public static void main(String[] args) {
        
        HoraTrabajadaService hts = new HoraTrabajadaService();
        TrabajadorService ts = new TrabajadorService();
        ActividadService as = new ActividadService();
        DireccionService ds = new DireccionService();
        ClienteService cs = new ClienteService();
        TipoProductoService tps = new TipoProductoService();
        ProductoService ps = new ProductoService();
        TrabajoService trabajoService = new TrabajoService();
        TrabajoProductoService trabajoProductoService = new TrabajoProductoService();
        
        Actividad soldar = new Actividad("Soldar");
        Actividad puntar = new Actividad("pintar");
        
        Direccion d1 = new Direccion("Calle1", "Colonia1", "Calle1", "123");
        Direccion d2 = new Direccion("Calle2", "Colonia2", "Calle2", "222");
        
        Trabajador juan = new Trabajador("Juan", "gfe", "comentario", LocalDate.now(), d1);
        
        Cliente cliente1 = new Cliente("nombre", "celular", "telefono", "comentario", d2);
        
        TipoProducto tipoProducto1 = new TipoProducto("tipoProducto1");
        
        Producto producto1 = new Producto("producto1", tipoProducto1);
        Producto producto2 = new Producto("producto2", tipoProducto1);
        
        TrabajoProducto tp = new TrabajoProducto(1, 100.50, producto1);
        TrabajoProducto tp2 = new TrabajoProducto(1, 100.50, producto1);
        TrabajoProducto tp3 = new TrabajoProducto(1, 100.50, producto2);
        
        List<TrabajoProducto> ltp = new ArrayList<TrabajoProducto>();
        
        
        
        Trabajo t = new Trabajo();
        t.setCliente(cliente1);
        t.setFechaAnticipo(LocalDate.now());
        
        
        tp.setTrabajo(t);
        tp2.setTrabajo(t);
        tp3.setTrabajo(t);
        ltp.add(tp);
        ltp.add(tp2);
        ltp.add(tp3);
        
        t.setProductosDelTrabajo(ltp);
        
        HoraTrabajada ht = new HoraTrabajada("1", soldar, juan, t);
        
        try {
            tps.GuardarTipoProducto(tipoProducto1);
            ps.GuardarProducto(producto1);
            ps.GuardarProducto(producto2);
            //trabajoProductoService.GuardarTrabajoProducto(tp);
            ts.GuardarTrabajador(juan);
            cs.GuardarCliente(cliente1);
            as.GuardarActividad(soldar);
            trabajoService.GuardarTrabajo(t);
            hts.GuardarHoraTrabajada(ht);
            
            Trabajo trabajoRecuperado = trabajoService.getTrabajo(1);
            for (TrabajoProducto trabajoProducto : trabajoRecuperado.getProductosDelTrabajo()) {
                System.out.println(trabajoProducto.getProducto().getNombre());
            }
            System.out.println("aber");
            System.out.println("no te mueras D:");
            
        } catch (UnableToSaveException ex) {
            Logger.getLogger(TestHoraTrabajada.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("c murio");
        } finally {
            System.exit(0);
        }
        
        
        
    }
    
}
