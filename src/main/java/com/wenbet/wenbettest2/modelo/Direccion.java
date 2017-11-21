/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

/**
 *  Representación de la tabla <b>Direccion</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica la dirección de persona o negocio
 * <br> <i> - Relación unidireccional uno a uno con {@link Trabajador} (Esta clase no conoce la dirección) </i>
 * <br> <i> - Relación unidireccional uno a uno con {@link Proveedor} (Esta clase no conoce la dirección) </i>
 * <br> <i> - Relación unidireccional uno a uno con {@link Cliente} (Esta clase no conoce la dirección) </i>
 * @author Roberto
 */
public class Direccion {
    
    private long id;
    private String ciudad;
    private String colonia; //TODO
    private String calle;
    private String numero;
    
    
    
}
