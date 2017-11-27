/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ActividadDAO;
import com.wenbet.wenbettest2.dao.IActividadDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class ActividadService implements IActividadService{

    private final IActividadDAO actividadDAO;

    public ActividadService() {
        actividadDAO = new ActividadDAO();
    }

    
    @Override
    public long GuardarActividad(Actividad actividadGuardar) throws UnableToSaveException {
        return actividadDAO.Guardar(actividadGuardar);
    }

    @Override
    public void ActualizarActividad(Actividad actividadActualizar) throws UnableToSaveException {
        actividadDAO.Actualizar(actividadActualizar);
    }

    @Override
    public void EliminarActividad(Actividad actividadEliminar) {
        actividadDAO.Eliminar(actividadEliminar);
    }

    @Override
    public List<Actividad> ListarActividades() {
        return actividadDAO.obtenerLista();
    }

    @Override
    public Actividad getActividad(long id) {
        return actividadDAO.getEntidad(id);
    }
    
    
    
}
