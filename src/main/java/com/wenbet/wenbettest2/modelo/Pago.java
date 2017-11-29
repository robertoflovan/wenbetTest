/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *  Representación de la tabla <b>Pago</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica un nuevo pago a un trabajo realizado
 * <br> <i> - Relación bidireccional muchos a uno con {@link Trabajo} </i>
 * @author Roberto
 */
public class Pago {
    
    private long id;
    private final ObjectProperty<LocalDate> fechaPago = new SimpleObjectProperty<>();
    private final DoubleProperty pago = new SimpleDoubleProperty();
    private final ObjectProperty<Trabajo> trabajo = new SimpleObjectProperty<>();

    public Pago() {
    }

    public Pago(LocalDate fecha, double pago) {
        this.fechaPago.set(fecha);
        this.pago.set(pago);
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

    public final void setPago(Double value) {
        pago.set(value);
    }

    public final Double getPago() {
        return pago.get();
    }

    public final DoubleProperty pagoProperty() {
        return pago;
    }
    
    //Trabajo
    public final void setTrabajo(Trabajo value) {
        trabajo.set(value);
    }

    @ManyToOne
    public final Trabajo getTrabajo() {
        return trabajo.get();
    }

    public final ObjectProperty trabajoProperty() {
        return trabajo;
    }
    
    
    
}
