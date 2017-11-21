/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *  Representación de la tabla <b>Trabajo</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Cliente} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación bidireccional uno a muchos con {@link TrabajoProducto} </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
class Trabajo {
    
    private long id;
    
    private LocalDate fechaAnticipo;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private LocalDate fechaInstalacion;
    private Double precioTotal;
    private String color;
    private String comentarios;
    
    private Cliente cliente;
    private List<TrabajoProducto> productosDelTrabajo;
    
}
