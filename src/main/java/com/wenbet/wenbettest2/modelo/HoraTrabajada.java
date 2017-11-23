/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>HoraTrabajada</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indican las horas dedicadas a alguna actividad de un trabajo.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Actividad} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajador} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajo} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
public class HoraTrabajada {
    
    private long id;
    private final StringProperty tiempoTrabajado = new SimpleStringProperty(); //TODO
    
    private final ObjectProperty<Actividad> actividad = new SimpleObjectProperty<>();
    private final ObjectProperty<Trabajador> trabajador = new SimpleObjectProperty<>();
    private final ObjectProperty<Trabajo> trabajo = new SimpleObjectProperty<>();
    
    
    //Getters setters and javafx properties

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

    public final Actividad getActividad() {
        return actividad.get();
    }

    public final ObjectProperty actividadProperty() {
        return actividad;
    }
    
    public final void setTrabajador(Trabajador value) {
        trabajador.set(value);
    }

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
