/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ActividadDAO;
import com.wenbet.wenbettest2.dao.IActividadDAO;
import com.wenbet.wenbettest2.modelo.Actividad;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class ActividadService implements IActividadService{

    private IActividadDAO actividadDAO;

    public ActividadService() {
        actividadDAO = new ActividadDAO();
    }

    
    @Override
    public void GuardarActividad(Actividad actividadGuardar) {
        //actividadDAO.Guardar(actividadGuardar);
    }

    @Override
    public void ActualizarActividad(Actividad actividadActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarActividad(Actividad actividadEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Actividad> ListarActividades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
