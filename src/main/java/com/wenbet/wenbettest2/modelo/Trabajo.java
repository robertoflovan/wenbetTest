/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import Util.ListUtil;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>Trabajo</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Cliente} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación bidireccional uno a muchos con {@link TrabajoProducto} </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
public class Trabajo {
    
    private long id;
    
    private final ObjectProperty<LocalDate> fechaAnticipo = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInicio = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaTermino = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInstalacion = new SimpleObjectProperty<>();
    
    private final DoubleProperty precioTotal = new SimpleDoubleProperty();
    private final StringProperty color = new SimpleStringProperty();
    private final StringProperty comentarios = new SimpleStringProperty();
    
    private final ObjectProperty<Cliente> cliente = new SimpleObjectProperty<>();
    
        //private final ObservableList<TrabajoProducto> productosDelTrabajoObservableList = FXCollections.observableArrayList();
        //private final ListProperty<TrabajoProducto> productosDelTrabajo = new SimpleListProperty<>(productosDelTrabajoObservableList);
    private final ListProperty<TrabajoProducto> productosDelTrabajo = ListUtil.inicializarListProperty();
    
    
    private Trabajo() {
        
    }
    
    public Trabajo(List<TrabajoProducto> productosDelTrabajo){
        ListUtil.llenarListProperty(this.productosDelTrabajo, productosDelTrabajo);
    }
    
    
    private void actualizarPrecioTotalTrabajo(){
        double pt = 0;
        for (TrabajoProducto trabajoProducto : productosDelTrabajo) {
            pt += trabajoProducto.getPrecio();
        }
        this.setPrecioTotal(pt);
    }
    
    //Setters, getters and javafx properties
    
    //Id

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
    
    // otros
    //Precio total 
    private void setPrecioTotal(Double value) {
        precioTotal.set(value);
    }

    public final Double getPrecioTotal() {
        return precioTotal.get();
    }

    public final DoubleProperty precioTotalProperty() {
        return precioTotal;
    }

    //TrabajoProducto (productosDelTrabajo)
    public List<TrabajoProducto> getProductosDelTrabajo(){
        return productosDelTrabajo.get();
    }

    public void setProductosDelTrabajo(List<TrabajoProducto> productosDelTrabajo){
        ListUtil.llenarListProperty(this.productosDelTrabajo, productosDelTrabajo);
        this.actualizarPrecioTotalTrabajo();
    }

    public void addProductoDeTrabajo(TrabajoProducto productoDeTrabajo){
            productosDelTrabajo.add(productoDeTrabajo);
            productoDeTrabajo.setTrabajo(this);
            this.actualizarPrecioTotalTrabajo();
    }
    
    
    
    //Color
    public final void setColor(String value) {
        color.set(value);
    }

    public final String getColor() {
        return color.get();
    }

    public final StringProperty colorProperty() {
        return color;
    }
    
    //Comentarios
    public final void setComentarios(String value) {
        comentarios.set(value);
    }

    public final String getComentarios() {
        return comentarios.get();
    }

    public final StringProperty comentariosProperty() {
        return comentarios;
    }
    
    //fechaAnticipo
    public LocalDate getFechaAnticipo() {
        return fechaAnticipo.get();
    }

    public void setFechaAnticipo(LocalDate fechaAnticipo) {
            this.fechaAnticipo.set(fechaAnticipo);
    }

    public ObjectProperty<LocalDate> fechaAnticipoProperty() {
            return fechaAnticipo;
    }
    
    //fechaInicio
    public LocalDate getFechaInicio() {
        return fechaInicio.get();
    }

    public void setFechaInicio(LocalDate fechaInicio) {
            this.fechaInicio.set(fechaInicio);
    }

    public ObjectProperty<LocalDate> fechaInicioProperty() {
            return fechaInicio;
    }
    
    //fechaTermino
    public LocalDate getFechaTermino() {
        return fechaTermino.get();
    }

    public void setFechaTermino(LocalDate fechaTermino) {
            this.fechaTermino.set(fechaTermino);
    }

    public ObjectProperty<LocalDate> fechaTerminoProperty() {
            return fechaTermino;
    }
    
    //fechaInstalacion
    public LocalDate getFechaInstalacion() {
        return fechaInstalacion.get();
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
            this.fechaInstalacion.set(fechaInstalacion);
    }

    public ObjectProperty<LocalDate> fechaInstalacionProperty() {
            return fechaInstalacion;
    }
    
    //Cliente
     public final void setCliente(Cliente value) {
        cliente.set(value);
    }

    public final Cliente getCliente() {
        return cliente.get();
    }

    public final ObjectProperty clienteProperty() {
        return cliente;
    }
}
