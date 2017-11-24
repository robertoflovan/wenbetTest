/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import Util.ListUtil;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>TipoProducto</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica el tipo de producto del trabajo realizado, como protecció, barandal, techo...
 * <br> <i> - Relación bidireccional uno a muchos {@link Producto)} </i>
 * asd {@link Producto)}
 * @author Roberto
 */
public class TipoProducto {
    
    private long id;
    
    private final StringProperty nombre = new SimpleStringProperty();
    
    private final ListProperty<Producto> productos = ListUtil.inicializarListProperty();
    
    private TipoProducto(){
    }
    
    private TipoProducto(String nombre){
        this.nombre.set(nombre);
    }
    
    //Getters, setters and javafx properties

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
    
    //productos
    public List<Producto> getProductos(){
        return productos.get();
    }

    public void setProductos(List<Producto> productos){
        ListUtil.llenarListProperty(this.productos, productos);
    }

    public void addProducto(Producto producto){
            productos.add(producto);
            producto.setTipoProducto(this);
    }
    
    
    
}
