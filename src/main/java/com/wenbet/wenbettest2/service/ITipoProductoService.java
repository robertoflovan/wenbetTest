/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface ITipoProductoService {
    
    public long GuardarTipoProducto(TipoProducto tipoProductoGuardar) throws UnableToSaveException;
    
    public void ActualizarTipoProducto(TipoProducto tipoProductoActualizar) throws UnableToSaveException;
     
    public void EliminarTipoProducto(TipoProducto tipoProductoEliminar) throws HibernateException;
    
    public TipoProducto getTipoProducto(long id);
     
    public List<TipoProducto> ListarTipoProductos();
    
}
