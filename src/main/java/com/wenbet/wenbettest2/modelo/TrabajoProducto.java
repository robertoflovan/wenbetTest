/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *  Representación de la tabla <b>TrabajoProducto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Tabla intermediaria entre trabajo y producto
 * <br> <i> - Relación bidireccional muchos a uno con {@link Trabajo}  </i>
 * <br> <i> - Relación unidireccional muchos a uno con {@link Producto} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
public class TrabajoProducto {
    
    private long id;
    
    private final IntegerProperty cantidad = new SimpleIntegerProperty();
    private final DoubleProperty precio = new SimpleDoubleProperty();
    
    private final ObjectProperty<Producto> producto = new SimpleObjectProperty<>();
    private final ObjectProperty<Trabajo> trabajo = new SimpleObjectProperty<>();

    private TrabajoProducto() {
    }
    

    
    public TrabajoProducto(int cantidad, double precio, Producto producto, Trabajo trabajo) {
        this.cantidad.set(cantidad);
        this.precio.set(precio);
        this.producto.set(producto);
        this.trabajo.set(trabajo);
    }
    
    //Getters, setters and javafx properties

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public final void setCantidad(Integer value) {
        cantidad.set(value);
    }

    public final Integer getCantidad() {
        return cantidad.get();
    }

    public final IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public final void setPrecio(Double value) {
        precio.set(value);
    }

    public final Double getPrecio() {
        return precio.get();
    }

    public final DoubleProperty precioProperty() {
        return precio;
    }
    
    //Producto
    public final void setProducto(Producto value) {
        producto.set(value);
    }

    public final Producto getProducto() {
        return producto.get();
    }

    public final ObjectProperty productoProperty() {
        return producto;
    }
    
    //Trabajo
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
