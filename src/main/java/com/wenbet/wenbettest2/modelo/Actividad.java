/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>Actividad</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica las actividades que los trabajadores dedican tiempo en un trabajo (Ej: soldar, pintar, pulir, etc...)
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
public class Actividad {
    
    private long id;
    private final StringProperty nombre = new SimpleStringProperty();

    public Actividad() {
    }

    public Actividad(String nombre){
        this.nombre.set(nombre);
    }
    
    
    //Getters, setters and javafx properties
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public final void setNombre(String value) {
        nombre.set(value);
    }

    public final String getNombre() {
        return nombre.get();
    }

    public final StringProperty nombreProperty() {
        return nombre;
    }
    
    
    
}
