/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ITrabajoProductoDAO;
import com.wenbet.wenbettest2.dao.TrabajoProductoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class TrabajoProductoService implements ITrabajoProductoService{

    private final ITrabajoProductoDAO trabajoProductoDAO;

    public TrabajoProductoService() {
        this.trabajoProductoDAO = new TrabajoProductoDAO();
    }

    @Override
    public long GuardarTrabajoProducto(TrabajoProducto trabajoProductoGuardar) throws UnableToSaveException {
        return trabajoProductoDAO.Guardar(trabajoProductoGuardar);
    }

    @Override
    public void ActualizarTrabajoProducto(TrabajoProducto trabajoProductoActualizar) throws UnableToSaveException {
        trabajoProductoDAO.Actualizar(trabajoProductoActualizar);
    }

    @Override
    public void EliminarTrabajoProducto(TrabajoProducto trabajoProductoEliminar) throws HibernateException {
        trabajoProductoDAO.Eliminar(trabajoProductoEliminar);
    }

    @Override
    public TrabajoProducto getTrabajoProducto(long id) {
        return trabajoProductoDAO.getEntidad(id);
    }

    @Override
    public List<TrabajoProducto> ListarTrabajoProductos() {
        return trabajoProductoDAO.obtenerLista();
    }
    
    
   
    
}
