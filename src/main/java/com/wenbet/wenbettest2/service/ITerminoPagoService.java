/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TerminoPago;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface ITerminoPagoService {
    
    public long GuardarTerminoPago(TerminoPago terminoPagoGuardar) throws UnableToSaveException;
    
    public void ActualizarTerminoPago(TerminoPago terminoPagoActualizar) throws UnableToSaveException;
     
    public void EliminarTerminoPago(TerminoPago terminoPagoEliminar) throws HibernateException;
    
    public TerminoPago getTerminoPago(long id);
     
    public List<TerminoPago> ListarTerminoPagos();
    
}
