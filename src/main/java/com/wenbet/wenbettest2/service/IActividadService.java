/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.modelo.Actividad;
import java.util.List;

/**
 *
 * @author Roberto
 */
public interface IActividadService {
    
    /**
     * Prueba doc
     * @param actividadGuardar 
     */
    public void GuardarActividad(Actividad actividadGuardar);
    
    public void ActualizarActividad(Actividad actividadActualizar);
     
    public void EliminarActividad(Actividad actividadEliminar);
    
    //public Actividad buscarActividad();
     
    public List<Actividad> ListarActividades();
     
    
}
