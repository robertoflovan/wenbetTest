/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *  Representación de la tabla <b>EstadoTrabajo</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el estado en que se encuentra el trabajo (Pendiente, en proceso, finalizado, etc...)
 * <br> <i> - Relación unidireccional uno a muchos con {@link Trabajo} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class EstadoTrabajo implements Serializable{
    
    private long id;
    private final StringProperty nombre = new SimpleStringProperty();

    public EstadoTrabajo() {
    }

    public EstadoTrabajo(String nombre) {
        this.nombre.set(nombre);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String value) {
        nombre.set(value);
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }
    
    
    
    
    
}
