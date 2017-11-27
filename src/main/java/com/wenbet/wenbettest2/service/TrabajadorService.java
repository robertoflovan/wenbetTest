/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ITrabajadorDAO;
import com.wenbet.wenbettest2.dao.TrabajadorDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajador;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class TrabajadorService implements ITrabajadorService{

    public final ITrabajadorDAO trabajadorDAO;

    public TrabajadorService() {
        this.trabajadorDAO = new TrabajadorDAO();
    }
    
    
    @Override
    public long GuardarTrabajador(Trabajador trabajadorGuardar) throws UnableToSaveException {
        return trabajadorDAO.Guardar(trabajadorGuardar);
    }

    @Override
    public void ActualizarTrabajador(Trabajador trabajadorActualizar) throws UnableToSaveException {
        trabajadorDAO.Actualizar(trabajadorActualizar);
    }

    @Override
    public void EliminarTrabajador(Trabajador trabajadorEliminar) throws HibernateException {
        trabajadorDAO.Eliminar(trabajadorEliminar);
    }

    @Override
    public Trabajador getTrabajador(long id) {
        return trabajadorDAO.getEntidad(id);
    }

    @Override
    public List<Trabajador> ListarTrabajadores() {
        return trabajadorDAO.obtenerLista();
    }
    
}
