/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.modelo.Direccion;
import com.wenbet.wenbettest2.modelo.HoraTrabajada;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.service.ActividadService;
import com.wenbet.wenbettest2.service.DireccionService;
import com.wenbet.wenbettest2.service.HoraTrabajadaService;
import com.wenbet.wenbettest2.service.TrabajadorService;
import java.time.LocalDate;
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
        ActividadService at = new ActividadService();
        DireccionService ds = new DireccionService();
        
        Actividad soldar = new Actividad("Soldar");
        Actividad puntar = new Actividad("pintar");
        
        Direccion d1 = new Direccion("Calle1", "Colonia1", "Calle1", "123");
        Direccion d2 = new Direccion("Calle2", "Colonia2", "Calle2", "222");
        
        Trabajador juan = new Trabajador("Juan", "gfe", "comentario", LocalDate.now(), d1);
        
        HoraTrabajada ht = new HoraTrabajada("1", soldar, juan, null);
        
        try {
            hts.GuardarHoraTrabajada(ht);
        } catch (UnableToSaveException ex) {
            Logger.getLogger(TestHoraTrabajada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
