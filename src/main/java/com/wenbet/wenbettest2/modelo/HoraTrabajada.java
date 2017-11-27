/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.io.Serializable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *  Representación de la tabla <b>HoraTrabajada</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indican las horas dedicadas a alguna actividad de un trabajo.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Actividad} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajador} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajo} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class HoraTrabajada implements Serializable{
    
    private long id;
    private final StringProperty tiempoTrabajado = new SimpleStringProperty(); //TODO
    
    private final ObjectProperty<Actividad> actividad = new SimpleObjectProperty<>();
    private final ObjectProperty<Trabajador> trabajador = new SimpleObjectProperty<>();
    private final ObjectProperty<Trabajo> trabajo = new SimpleObjectProperty<>();

    public HoraTrabajada() {
    }
    
    public HoraTrabajada(String tiempoTrabajado, Actividad actividad, Trabajador trabajador, Trabajo trabajo) {
        this.tiempoTrabajado.set(tiempoTrabajado);
        this.actividad.set(actividad);
        this.trabajador.set(trabajador);
        this.trabajo.set(trabajo);
    }
    
    
    //Getters setters and javafx properties
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public final void setTiempoTrabajado(String value) {
        tiempoTrabajado.set(value);
    }

    public final String getTiempoTrabajado() {
        return tiempoTrabajado.get();
    }

    public final StringProperty tiempoTrabajadoProperty() {
        return tiempoTrabajado;
    }
    
    public final void setActividad(Actividad value) {
        actividad.set(value);
    }

    @ManyToOne
    public final Actividad getActividad() {
        return actividad.get();
    }

    public final ObjectProperty actividadProperty() {
        return actividad;
    }
    
    public final void setTrabajador(Trabajador value) {
        trabajador.set(value);
    }

    @ManyToOne
    public final Trabajador getTrabajador() {
        return trabajador.get();
    }

    public final ObjectProperty trabajadorProperty() {
        return trabajador;
    }
    
    public final void setTrabajo(Trabajo value) {
        trabajo.set(value);
    }

    public final Trabajo getTrabajo() {
        return trabajo.get();
    }

    public final ObjectProperty trabajoProperty() {
        return trabajo;
    }
    
}
