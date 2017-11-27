/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.dao.DireccionDAO;
import com.wenbet.wenbettest2.dao.TrabajadorDAO;
import com.wenbet.wenbettest2.dao.TrabajoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Direccion;
import com.wenbet.wenbettest2.modelo.Trabajador;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class TestTrabajoDireccion {
    
    public static void main(String[] args) {
        
        DireccionDAO direccionDAO = new DireccionDAO();
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        
        Direccion d1 = new Direccion("Ciudad", "Colonia", "Calle", "Numero");
        Direccion d2 = new Direccion("Ciudad2", "Colonia2", "Calle2", "Numero2");
        Direccion d3 = new Direccion("Ci3udad32", "Co3lo3nia2", "Cal33le2", "Nu3mer3o2");
        
        Trabajador t1 = new Trabajador("nombre", "puesto", "comentario1", LocalDate.now(), d1);
        Trabajador tw = new Trabajador("nombrew", "puestow", "comentariow2", LocalDate.now(), d2);
        
        try {
            
            direccionDAO.Guardar(d3);
            trabajadorDAO.Guardar(t1);
            trabajadorDAO.Guardar(tw);
            direccionDAO.Eliminar(d3);
            Trabajador trabajadorEliminar = trabajadorDAO.getEntidad((long) 1);
            trabajadorDAO.Eliminar(trabajadorEliminar);
            Trabajador trabajadorActualizar = trabajadorDAO.getEntidad((long) 2);
            Direccion dr = trabajadorActualizar.getDireccion();
            dr.setColonia("EDITED");
            direccionDAO.Actualizar(dr);
            
            //Direccion id3Recuperada = direccionDAO.getEntidad((long) 3);
            //id3Recuperada.setCalle("Edited2 sin ref trabajador");
            
        } catch (UnableToSaveException ex) {
            Logger.getLogger(TestTrabajoDireccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
        
    }
    
}
