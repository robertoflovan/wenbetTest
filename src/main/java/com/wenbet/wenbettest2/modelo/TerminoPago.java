/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.io.Serializable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *  Representación de la tabla <b>TerminoPago</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el color del trabajo a realizar
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajo} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class TerminoPago implements Serializable{
    
    private long id;
    private final BooleanProperty cantidad = new SimpleBooleanProperty(false);
    private final IntegerProperty lapsos = new SimpleIntegerProperty();
    private final IntegerProperty numPagos = new SimpleIntegerProperty();

    public TerminoPago() {
    }

    public TerminoPago(int lapsos, int numPagos) {
        this.lapsos.set(lapsos);
        this.numPagos.set(numPagos);
    }
    
    //Getters, setters and javafx properties
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public final void setCantidad(Boolean value) {
        cantidad.set(value);
    }

    public final Boolean getCantidad() {
        return cantidad.get();
    }

    public final BooleanProperty cantidadProperty() {
        return cantidad;
    }

    public final void setLapsos(Integer value) {
        lapsos.set(value);
    }

    public final Integer getLapsos() {
        return lapsos.get();
    }

    public final IntegerProperty lapsosProperty() {
        return lapsos;
    }

    public final void setNumPagos(Integer value) {
        numPagos.set(value);
    }

    public final Integer getNumPagos() {
        return numPagos.get();
    }

    public final IntegerProperty numPagosProperty() {
        return numPagos;
    }
    
}
