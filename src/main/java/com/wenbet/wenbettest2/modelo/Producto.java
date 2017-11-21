/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.util.List;

/**
 *  Representación de la tabla <b>Producto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el producto que se realizará al cliente, con medidas si es aplicable.
 * <br> <i> - Relación bidireccional muchos a uno con {@link TipoProducto} </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link TrabajoProducto} (Esta clase no conoce la relación)</i>
 * @author Roberto
 */
public class Producto {
    
    private long id;
    private String nombre;
    
    private TipoProducto tipoProducto;
    
}
