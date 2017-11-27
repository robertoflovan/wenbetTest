/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajo;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface ITrabajoService {
    
    public long GuardarTrabajo(Trabajo trabajoGuardar) throws UnableToSaveException;
    
    public void ActualizarTrabajo(Trabajo trabajoActualizar) throws UnableToSaveException;
     
    public void EliminarTrabajo(Trabajo trabajoEliminar) throws HibernateException;
    
    public Trabajo getTrabajo(long id);
     
    public List<Trabajo> ListarTrabajos();
    
    
}
