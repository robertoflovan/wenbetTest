/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ITerminoPagoDAO;
import com.wenbet.wenbettest2.dao.TerminoPagoDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TerminoPago;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class TerminoPagoService implements ITerminoPagoService{

    private final ITerminoPagoDAO terminoPagoDAO;

    public TerminoPagoService() {
        this.terminoPagoDAO = new TerminoPagoDAO();
    }
    
    
    @Override
    public long GuardarTerminoPago(TerminoPago terminoPagoGuardar) throws UnableToSaveException {
        return terminoPagoDAO.Guardar(terminoPagoGuardar);
    }

    @Override
    public void ActualizarTerminoPago(TerminoPago terminoPagoActualizar) throws UnableToSaveException {
        terminoPagoDAO.Actualizar(terminoPagoActualizar);
    }

    @Override
    public void EliminarTerminoPago(TerminoPago terminoPagoEliminar) throws HibernateException {
        terminoPagoDAO.Eliminar(terminoPagoEliminar);
    }

    @Override
    public TerminoPago getTerminoPago(long id) {
        return terminoPagoDAO.getEntidad(id);
    }

    @Override
    public List<TerminoPago> ListarTerminoPagos() {
        return terminoPagoDAO.obtenerLista();
    }
    
}
