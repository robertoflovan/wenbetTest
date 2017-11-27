/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Direccion;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IDireccionService {
    
    public long GuardarDireccion(Direccion direccionGuardar) throws UnableToSaveException;
    
    public void ActualizarDireccion(Direccion direccionActualizar) throws UnableToSaveException;
     
    public void EliminarDireccion(Direccion direccionEliminar) throws HibernateException;
    
    public Direccion getDireccion(long id);
     
    public List<Direccion> ListarDirecciones();
    
}
