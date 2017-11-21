/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

/**
 *  Representación de la tabla <b>Actividad</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica las actividades que los trabajadores dedican tiempo en un trabajo (Ej: soldar, pintar, pulir, etc...)
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
public class Actividad {
    
    private long id;
    private String nombre;
    
}
