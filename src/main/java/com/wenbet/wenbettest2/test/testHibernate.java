/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.util.HibernateUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author USER
 */
public class testHibernate {
    
    public static void main(String[] args) {
        
        Actividad a = new Actividad("soldar");
        //////////////////
        
        HibernateUtil hu = new HibernateUtil();
        long id = 0;  

        try 
        { 
            
            id = (Long)hu.iniciarOperacion().save(a);
            
        }catch(HibernateException he) 
        { 
            System.out.println("termino de guardado");
            throw he; 
        }finally 
        { 
            hu.terminaOperacion();
        }
        
        
        Actividad actividadRecuperada = hu.iniciarOperacion().get(Actividad.class, id);
        hu.terminaOperacion();
        
        System.out.println("asd");
        System.out.println(actividadRecuperada.getNombre());
        
        actividadRecuperada.setNombre("Pintura (edit)");
        
        System.out.println("----------------------------------------------------------------------");
        System.out.println(actividadRecuperada.getNombre());
        
        
        hu.iniciarOperacion().update(actividadRecuperada);
        hu.terminaOperacion();
        
        Actividad a2 = new Actividad("Nueva actividad");
        hu.iniciarOperacion().save(a2);
        hu.terminaOperacion();
        
        hu.iniciarOperacion().delete(actividadRecuperada);
        hu.terminaOperacion();
        
        Actividad a3 = new Actividad("after delete");
        hu.iniciarOperacion().save(a3);
        hu.terminaOperacion();
        
        System.exit(0);
    }
    
}
