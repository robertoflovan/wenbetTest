/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Color;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IColorService {
    
    public long GuardarColor(Color colorGuardar) throws UnableToSaveException;
    
    public void ActualizarColor(Color colorActualizar) throws UnableToSaveException;
     
    public void EliminarColor(Color colorEliminar) throws HibernateException;
    
    public Color getColor(long id);
     
    public List<Color> ListarColores();
    
}
