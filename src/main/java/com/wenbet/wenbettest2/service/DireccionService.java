/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ClienteDAO;
import com.wenbet.wenbettest2.dao.DireccionDAO;
import com.wenbet.wenbettest2.dao.IClienteDAO;
import com.wenbet.wenbettest2.dao.IDireccionDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Direccion;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class DireccionService implements IDireccionService{
    
    private final IDireccionDAO direccionDAO;

    public DireccionService() {
        this.direccionDAO = new DireccionDAO();
    }

    @Override
    public long GuardarDireccion(Direccion direccionGuardar) throws UnableToSaveException {
        return direccionDAO.Guardar(direccionGuardar);
    }

    @Override
    public void ActualizarDireccion(Direccion direccionActualizar) throws UnableToSaveException {
        direccionDAO.Actualizar(direccionActualizar);
    }

    @Override
    public void EliminarDireccion(Direccion direccionEliminar) throws HibernateException {
        direccionDAO.Eliminar(direccionEliminar);
    }

    @Override
    public Direccion getDireccion(long id) {
        return direccionDAO.getEntidad(id);
    }

    @Override
    public List<Direccion> ListarDirecciones() {
        return direccionDAO.obtenerLista();
    }

    
    
}
