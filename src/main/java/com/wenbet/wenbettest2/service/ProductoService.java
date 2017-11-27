/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.IProductoDAO;
import com.wenbet.wenbettest2.dao.ProductoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Producto;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class ProductoService implements IProductoService{

    public final IProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }
    
    
    
    @Override
    public long GuardarProducto(Producto productoGuardar) throws UnableToSaveException {
        return productoDAO.Guardar(productoGuardar);
    }

    @Override
    public void ActualizarProducto(Producto productoActualizar) throws UnableToSaveException {
        productoDAO.Actualizar(productoActualizar);
    }

    @Override
    public void EliminarProducto(Producto productoEliminar) throws HibernateException {
        productoDAO.Eliminar(productoEliminar);
    }

    @Override
    public Producto getProducto(long id) {
        return productoDAO.getEntidad(id);
    }

    @Override
    public List<Producto> ListarProductos() {
        return productoDAO.obtenerLista();
    }
    
}
