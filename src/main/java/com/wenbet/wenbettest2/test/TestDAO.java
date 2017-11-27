/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.service.ActividadService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto
 */
public class TestDAO {
    
    public static void main(String[] args) {
        
        ActividadService a = new ActividadService();
        Actividad act1 = new Actividad();
        act1.setNombre("Pintar");
        Actividad act2 = new Actividad("Soldar");
        long idGuardada = -1;
        try {
            idGuardada = a.GuardarActividad(act1);
            a.GuardarActividad(act2);
        } catch (UnableToSaveException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Actividad actRecuperada = a.getActividad(idGuardada);
        Actividad actRecuperada2 = a.getActividad(2);
        
        System.out.println(actRecuperada.getNombre());
        System.out.println(actRecuperada2.getNombre());
        
        actRecuperada2.setNombre("(EDIT)");
        
        try {
            a.ActualizarActividad(actRecuperada2);
        } catch (UnableToSaveException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
