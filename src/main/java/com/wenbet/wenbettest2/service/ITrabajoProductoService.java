/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface ITrabajoProductoService {
   
    public long GuardarTrabajoProducto(TrabajoProducto trabajoProductoGuardar) throws UnableToSaveException;
    
    public void ActualizarTrabajoProducto(TrabajoProducto trabajoProductoActualizar) throws UnableToSaveException;
     
    public void EliminarTrabajoProducto(TrabajoProducto trabajoProductoEliminar) throws HibernateException;
    
    public TrabajoProducto getTrabajoProducto(long id);
     
    public List<TrabajoProducto> ListarTrabajoProductos();
    
}
