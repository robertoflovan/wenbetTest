/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

/**
 *  Representación de la tabla <b>TrabajoProducto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Tabla intermediaria entre trabajo y producto
 * <br> <i> - Relación bidireccional muchos a uno con {@link Trabajo}  </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Producto} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
public class TrabajoProducto {
    
    private long id;
    private int cantidad;
    private double precio;
    
    private Producto producto;
    private Trabajo trabajo;
    
}
