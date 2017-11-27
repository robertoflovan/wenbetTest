/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.generic;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author usuario
 * @param <Entity> Clase de modelo
 * @param <PK> Tipo de la llave primaria
 */
public interface GenericDao<Entity, PK extends Serializable> {
    
    public PK Guardar(Entity t) throws UnableToSaveException;
    
    public void Actualizar(Entity t) throws UnableToSaveException;
    
    public Entity getEntidad(PK id);
    
    public void Eliminar(Entity t);
    
    public List<Entity> obtenerLista();
    
}
