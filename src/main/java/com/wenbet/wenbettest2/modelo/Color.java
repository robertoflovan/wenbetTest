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
 *  Representación de la tabla <b>Color</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el color del trabajo a realizar
 * <br> <i> - Relación unidireccional muchos a uno con {@link Trabajo} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class Color implements Serializable{
    
    private long id;
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty marca = new SimpleStringProperty();
    private final StringProperty perzonalizado = new SimpleStringProperty();

    public Color() {
    }
    
    public Color(String nombre, String marca){
        this.nombre.set(nombre);
        this.marca.set(marca);
    }
    
    public Color(String perzonalizado){
        this.perzonalizado.set(perzonalizado);
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

    public final void setNombre(String value) {
        nombre.set(value);
    }

    public final String getNombre() {
        return nombre.get();
    }

    public final StringProperty nombreProperty() {
        return nombre;
    }

    public final void setMarca(String value) {
        marca.set(value);
    }

    public final String getMarca() {
        return marca.get();
    }

    public final StringProperty marcaProperty() {
        return marca;
    }

    public final void setPerzonalizado(String value) {
        perzonalizado.set(value);
    }

    public final String getPerzonalizado() {
        return perzonalizado.get();
    }

    public final StringProperty perzonalizadoProperty() {
        return perzonalizado;
    }
    
    
    
    
}
