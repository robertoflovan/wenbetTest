/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>Cliente</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional uno a uno con {@link Direccion} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link Trabajo} (Esta clase no conoce la) </i>
 * @author Roberto
 */
public class Cliente {
    
    private long id;
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty celular = new SimpleStringProperty();
    private final StringProperty telefono = new SimpleStringProperty();
    private final StringProperty comentarios = new SimpleStringProperty();

    private final ObjectProperty<Direccion> direccion = new SimpleObjectProperty<>();

    private Cliente() {
    }

    public Cliente(String nombre, String celular, String telefono, String comentarios, Direccion direccion) {
        this.nombre.set(nombre);
        this.celular.set(celular);
        this.telefono.set(telefono);
        this.comentarios.set(comentarios);
        
        this.direccion.set(direccion);
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

    public final void setCeuluar(String value) {
        celular.set(value);
    }

    public final String getCeuluar() {
        return celular.get();
    }

    public final StringProperty ceuluarProperty() {
        return celular;
    }

    public final void setTelefono(String value) {
        telefono.set(value);
    }

    public final String getTelefono() {
        return telefono.get();
    }

    public final StringProperty telefonoProperty() {
        return telefono;
    }

    public final void setComentarios(String value) {
        comentarios.set(value);
    }

    public final String getComentarios() {
        return comentarios.get();
    }

    public final StringProperty comentariosProperty() {
        return comentarios;
    }
    
    
    
}
