/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.HoraTrabajada;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IHoraTrabajadaService {
    
    public long GuardarHoraTrabajada(HoraTrabajada horaTrabajadaGuardar) throws UnableToSaveException;
    
    public void ActualizarHoraTrabajada(HoraTrabajada horaTrabajadaActualizar) throws UnableToSaveException;
     
    public void EliminarHoraTrabajada(HoraTrabajada horaTrabajadaEliminar) throws HibernateException;
    
    public HoraTrabajada getHoraTrabajada(long id);
     
    public List<HoraTrabajada> ListarHoraTrabajadas();
    
}
