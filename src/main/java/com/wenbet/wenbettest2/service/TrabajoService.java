/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ITrabajoDAO;
import com.wenbet.wenbettest2.dao.TrabajoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajo;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class TrabajoService implements ITrabajoService{

    private final ITrabajoDAO trabajoDAO;

    public TrabajoService() {
        this.trabajoDAO = new TrabajoDAO();
    }
    
    
    @Override
    public long GuardarTrabajo(Trabajo trabajoGuardar) throws UnableToSaveException {
        return trabajoDAO.Guardar(trabajoGuardar);
    }

    @Override
    public void ActualizarTrabajo(Trabajo trabajoActualizar) throws UnableToSaveException {
        trabajoDAO.Actualizar(trabajoActualizar);
    }

    @Override
    public void EliminarTrabajo(Trabajo trabajoEliminar) throws HibernateException {
        trabajoDAO.Eliminar(trabajoEliminar);
    }

    @Override
    public Trabajo getTrabajo(long id) {
        return trabajoDAO.getEntidad(id);
    }

    @Override
    public List<Trabajo> ListarTrabajos() {
        return trabajoDAO.obtenerLista();
    }
    
}
