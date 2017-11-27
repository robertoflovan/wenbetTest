/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IActividadService {
    
    public long GuardarActividad(Actividad actividadGuardar) throws UnableToSaveException;
    
    public void ActualizarActividad(Actividad actividadActualizar) throws UnableToSaveException;
     
    public void EliminarActividad(Actividad actividadEliminar) throws HibernateException;
    
    public Actividad getActividad(long id);
     
    public List<Actividad> ListarActividades();
     
    
}
