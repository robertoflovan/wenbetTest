/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.util.HibernateUtil;
import java.util.List;

public class GenericDaoImpl<Entity, K extends Serializable> implements GenericDao<Entity, K> {

    public Class<Entity> domainClass = getDomainClass();
    private static final HibernateUtil HU = new HibernateUtil();

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

//    private Session getHibernateTemplate() {
//        session = com.wenbet.wenbettest2.util.HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        return session;
//    }

    @Override
    public Entity getEntidad(K id) {
        Entity returnValue = (Entity) HU.iniciarOperacion().get(domainClass, id);
        HU.terminaOperacion();
        return returnValue;
    }

    @Override
    public void Actualizar(Entity t) throws UnableToSaveException {
        try {
            HU.iniciarOperacion().update(t);
            HU.terminaOperacion();
        } catch (HibernateException e) {
            throw new UnableToSaveException(e);
        }
    }

    @Override
    public K Guardar(Entity t) throws UnableToSaveException {
        K id = null;
        try {
            id = (K) HU.iniciarOperacion().save(t);
            HU.terminaOperacion();
        } catch (HibernateException e) {
            throw new UnableToSaveException(e);
        }
        return id;
    }

    @Override
    public void Eliminar(Entity t) throws HibernateException{
 
            HU.iniciarOperacion().delete(t);
            HU.terminaOperacion();
        
    }
    
    @Override
    public List<Entity> obtenerLista(){
        //String query = "FROM " + domainClass.getSimpleName() + " x";
        List<Entity> list = HU.iniciarOperacion().createQuery("FROM " + domainClass.getSimpleName()).list();
        HU.terminaOperacion();
        return list;
    }
}
