/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.HoraTrabajadaDAO;
import com.wenbet.wenbettest2.dao.IHoraTrabajadaDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.HoraTrabajada;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class HoraTrabajadaService implements IHoraTrabajadaService{

    public final IHoraTrabajadaDAO horaTrabajadaDAO;

    public HoraTrabajadaService() {
        this.horaTrabajadaDAO = new HoraTrabajadaDAO();
    }
    
    
    @Override
    public long GuardarHoraTrabajada(HoraTrabajada horaTrabajadaGuardar) throws UnableToSaveException {
        return horaTrabajadaDAO.Guardar(horaTrabajadaGuardar);
    }

    @Override
    public void ActualizarHoraTrabajada(HoraTrabajada horaTrabajadaActualizar) throws UnableToSaveException {
        horaTrabajadaDAO.Actualizar(horaTrabajadaActualizar);
    }

    @Override
    public void EliminarHoraTrabajada(HoraTrabajada horaTrabajadaEliminar) throws HibernateException {
        horaTrabajadaDAO.Eliminar(horaTrabajadaEliminar);
    }

    @Override
    public HoraTrabajada getHoraTrabajada(long id) {
        return horaTrabajadaDAO.getEntidad(id);
    }

    @Override
    public List<HoraTrabajada> ListarHoraTrabajadas() {
        return horaTrabajadaDAO.obtenerLista();
    }
    
}
