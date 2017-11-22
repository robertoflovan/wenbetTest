/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.time.LocalDate;

/**
 *  Representación de la tabla <b>Trabajador</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional uno a uno {@link Direccion} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
public class Trabajador {
    
    private long id;
    private final StringProperty nombre;
    private final StringProperty puesto;
    private final StringProperty comentarios;
    private final ObjectProperty<LocalDate> fechaAlta;
    
    private final ObjectProperty<Direccion> direccion;
    
    
}
