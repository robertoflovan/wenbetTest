/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import java.util.List;

public class GenericDaoImpl<Entity, K extends Serializable> implements GenericDao<Entity, K> {

    public Class<Entity> domainClass = getDomainClass();
    private Session session;

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private Session getHibernateTemplate() {
        session = com.wenbet.wenbettest2.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public Entity Buscar(K id) {
        Entity returnValue = (Entity) getHibernateTemplate().load(domainClass, id);
        session.getTransaction().commit();
        return returnValue;
    }

    @Override
    public void Actualizar(Entity t) throws UnableToSaveException {
        try {
            getHibernateTemplate().update(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new UnableToSaveException(e);
        }
    }

    @Override
    public void Guardar(Entity t) throws UnableToSaveException {
        try {
            getHibernateTemplate().save(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new UnableToSaveException(e);
        }
    }

    @Override
    public void Eliminar(Entity t) {
        getHibernateTemplate().delete(t);
        session.getTransaction().commit();
    }
    
    @Override
    public List<Entity> obtenerLista(){
        String query = "FROM " + domainClass.getSimpleName() + " x";
        List<Entity> list = getHibernateTemplate().createQuery(query,domainClass).getResultList();
        session.getTransaction().commit();
        return list;
    }
}
