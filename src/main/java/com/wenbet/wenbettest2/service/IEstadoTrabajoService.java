/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.EstadoTrabajo;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IEstadoTrabajoService {
    
    public long GuardarEstadoTrabajo(EstadoTrabajo EstadoTrabajoGuardar) throws UnableToSaveException;
    
    public void ActualizarEstadoTrabajo(EstadoTrabajo estadoTrabajoActualizar) throws UnableToSaveException;
     
    public void EliminarEstadoTrabajo(EstadoTrabajo estadoTrabajoEliminar) throws HibernateException;
    
    public EstadoTrabajo getEstadoTrabajo(long id);
     
    public List<EstadoTrabajo> ListarEstadoTrabajos();
    
}
