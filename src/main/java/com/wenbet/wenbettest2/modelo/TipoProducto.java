/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.util.List;

/**
 *  Representación de la tabla <b>TipoProducto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el tipo de producto del trabajo realizado, como protecció, barandal, techo...
 * <br> <i> - Relación bidireccional uno a muchos {@link Producto)} </i>
 * asd {@link Producto)}
 * @author Roberto
 */
public class TipoProducto {
    
    private long id;
    private String nombre;
    
    private List<Producto> productos;
    
    
}
