/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.util.List;

/**
 *  Representación de la tabla <b>HoraTrabajada</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indican las horas dedicadas a alguna actividad de un trabajo.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Actividad} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajador} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajo} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
public class HoraTrabajada {
    
    private long id;
    private String tiempoTrabajado; //TODO
    
    private Actividad actividad;
    private Trabajador trabajador;
    private Trabajo trabajo;
    
}
