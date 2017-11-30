/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ColorDAO;
import com.wenbet.wenbettest2.dao.IColorDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Color;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class ColorService implements IColorService{

    private final IColorDAO colorDAO;

    public ColorService() {
        this.colorDAO = new ColorDAO();
    }
    
    
    @Override
    public long GuardarColor(Color colorGuardar) throws UnableToSaveException {
        return colorDAO.Guardar(colorGuardar);
    }

    @Override
    public void ActualizarColor(Color colorActualizar) throws UnableToSaveException {
        colorDAO.Actualizar(colorActualizar);
    }

    @Override
    public void EliminarColor(Color colorEliminar) throws HibernateException {
        colorDAO.Eliminar(colorEliminar);
    }

    @Override
    public Color getColor(long id) {
        return colorDAO.getEntidad(id);
    }

    @Override
    public List<Color> ListarColores() {
        return colorDAO.obtenerLista();
    }
    
}
