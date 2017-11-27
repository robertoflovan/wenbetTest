/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.dao.ClienteDAO;
import com.wenbet.wenbettest2.dao.IClienteDAO;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public class ClienteService implements IClienteService{

    private final IClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public long GuardarCliente(Cliente clienteGuardar) throws UnableToSaveException {
        return clienteDAO.Guardar(clienteGuardar);
    }

    @Override
    public void ActualizarCliente(Cliente clienteActualizar) throws UnableToSaveException {
        clienteDAO.Actualizar(clienteActualizar);
    }

    @Override
    public void EliminarCliente(Cliente clienteEliminar) throws HibernateException {
        clienteDAO.Eliminar(clienteEliminar);
    }

    @Override
    public Cliente getCliente(long id) {
        return clienteDAO.getEntidad(id);
    }

    @Override
    public List<Cliente> ListarClientes() {
        return clienteDAO.obtenerLista();
    }
    
    
    
}
