/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.service;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Roberto
 */
public interface IClienteService {
    
    public long GuardarCliente(Cliente clienteGuardar) throws UnableToSaveException;
    
    public void ActualizarCliente(Cliente clienteActualizar) throws UnableToSaveException;
     
    public void EliminarCliente(Cliente clienteEliminar) throws HibernateException;
    
    public Cliente getCliente(long id);
     
    public List<Cliente> ListarClientes();
    
}
