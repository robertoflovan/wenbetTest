/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Producto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IProductoService {
 
    public long GuardarProducto(Producto productoGuardar) throws UnableToSaveException;
    
    public void ActualizarProducto(Producto productoActualizar) throws UnableToSaveException;
     
    public void EliminarProducto(Producto productoEliminar) throws HibernateException;
    
    public Producto getProducto(long id);
     
    public List<Producto> ListarProductos();
    
}
