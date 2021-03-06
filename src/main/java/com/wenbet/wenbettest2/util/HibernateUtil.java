/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{  
    private static final SessionFactory sessionFactory;   

    static 
    { 
        try 
        { 
            sessionFactory = new Configuration().configure().buildSessionFactory(); 
        } catch (HibernateException he) 
        { 
           System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
            throw new ExceptionInInitializerError(he); 
        } 
    }  

    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    }
    
    
    private Session session;

    public HibernateUtil() {
    }
    
    public Session iniciarOperacion() {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }
    
    public void terminaOperacion(){
        session.getTransaction().commit();
        session.close();
    }
    
    
}