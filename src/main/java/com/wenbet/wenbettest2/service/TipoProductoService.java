/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ITipoProductoDAO;
import com.wenbet.wenbettest2.dao.TipoProductoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class TipoProductoService implements ITipoProductoService{

    private final ITipoProductoDAO tipoProductoDAO;

    public TipoProductoService() {
        this.tipoProductoDAO = new TipoProductoDAO();
    }
    
    
    @Override
    public long GuardarTipoProducto(TipoProducto tipoProductoGuardar) throws UnableToSaveException {
        return tipoProductoDAO.Guardar(tipoProductoGuardar);
    }

    @Override
    public void ActualizarTipoProducto(TipoProducto tipoProductoActualizar) throws UnableToSaveException {
        tipoProductoDAO.Actualizar(tipoProductoActualizar);
    }

    @Override
    public void EliminarTipoProducto(TipoProducto tipoProductoEliminar) throws HibernateException {
        tipoProductoDAO.Eliminar(tipoProductoEliminar);
    }

    @Override
    public TipoProducto getTipoProducto(long id) {
        return tipoProductoDAO.getEntidad(id);
    }

    @Override
    public List<TipoProducto> ListarTipoProductos() {
        return tipoProductoDAO.obtenerLista();
    }
    
}
