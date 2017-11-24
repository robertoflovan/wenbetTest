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
 *  Representación de la tabla <b>Producto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el producto que se realizará al cliente, con medidas si es aplicable.
 * <br> <i> - Relación bidireccional muchos a uno con {@link TipoProducto} </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link TrabajoProducto} (Esta clase no conoce la relación)</i>
 * @author Roberto
 */
public class Producto {
    
    private long id;
    
    private final StringProperty nombre = new SimpleStringProperty();
    
    private final ObjectProperty<TipoProducto> tipoProducto = new SimpleObjectProperty<>();

    private Producto() {
    }
    
    public Producto(String nombre, TipoProducto tipoProducto) {
        this.nombre.set(nombre);
        this.tipoProducto.set(tipoProducto);
    }
    
    //Setters, getters and javafx properties

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
    
    //TipoProducto
    public final void setTipoProducto(TipoProducto value) {
        tipoProducto.set(value);
        //TODO
    }

    public final TipoProducto getTipoProducto() {
        return tipoProducto.get();
    }

    public final ObjectProperty<TipoProducto> tipoProductoProperty() {
        return tipoProducto;
    }
    
}
