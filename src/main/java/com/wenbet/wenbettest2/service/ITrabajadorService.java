/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajador;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface ITrabajadorService {
    
    public long GuardarTrabajador(Trabajador trabajadorGuardar) throws UnableToSaveException;
    
    public void ActualizarTrabajador(Trabajador trabajadorActualizar) throws UnableToSaveException;
     
    public void EliminarTrabajador(Trabajador trabajadorEliminar) throws HibernateException;
    
    public Trabajador getTrabajador(long id);
     
    public List<Trabajador> ListarTrabajadores();
    
}
