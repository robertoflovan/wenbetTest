/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.EstadoTrabajoDAO;
import com.wenbet.wenbettest2.dao.IEstadoTrabajoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.EstadoTrabajo;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class EstadoTrabajoService implements IEstadoTrabajoService{

    private final IEstadoTrabajoDAO estadoTrabajoDAO;

    public EstadoTrabajoService() {
        this.estadoTrabajoDAO = new EstadoTrabajoDAO();
    }
    
    
    @Override
    public long GuardarEstadoTrabajo(EstadoTrabajo EstadoTrabajoGuardar) throws UnableToSaveException {
        return estadoTrabajoDAO.Guardar(EstadoTrabajoGuardar);
    }

    @Override
    public void ActualizarEstadoTrabajo(EstadoTrabajo estadoTrabajoActualizar) throws UnableToSaveException {
        estadoTrabajoDAO.Actualizar(estadoTrabajoActualizar);
    }

    @Override
    public void EliminarEstadoTrabajo(EstadoTrabajo estadoTrabajoEliminar) throws HibernateException {
        estadoTrabajoDAO.Eliminar(estadoTrabajoEliminar);
    }

    @Override
    public EstadoTrabajo getEstadoTrabajo(long id) {
        return estadoTrabajoDAO.getEntidad(id);
    }

    @Override
    public List<EstadoTrabajo> ListarEstadoTrabajos() {
        return estadoTrabajoDAO.obtenerLista();
    }
    
    
    
}
