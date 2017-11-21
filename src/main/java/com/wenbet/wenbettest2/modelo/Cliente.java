/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.util.List;

/**
 *  Representación de la tabla <b>Cliente</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional uno a uno con {@link Direccion} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link Trabajo} (Esta clase no conoce la) </i>
 * @author Roberto
 */
public class Cliente {
    
    private long id;
    private String nombre;
    private String ceuluar;
    private String telefono;
    private String correo;
    private String comentarios;
    
    private Direccion direccion;
    
    
}
