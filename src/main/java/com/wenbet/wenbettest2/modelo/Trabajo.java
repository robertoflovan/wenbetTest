/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import com.wenbet.wenbettest2.util.ListUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *  Representación de la tabla <b>Trabajo</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional muchos a uno con {@link Cliente} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación bidireccional uno a muchos con {@link TrabajoProducto} </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link EstadoTrabajo} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación bidireccional uno a muchos con {@link Pago}  </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link Color} (Sólo esta clase conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class Trabajo implements Serializable{
    
    private long id;
    
    private final ObjectProperty<LocalDate> fechaAnticipo = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInicio = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaTermino = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInstalacion = new SimpleObjectProperty<>();
    
    private final StringProperty comentarios = new SimpleStringProperty();
    private final StringProperty tiempoEstimadoTermino = new SimpleStringProperty();
    private final DoubleProperty costoTotal = new SimpleDoubleProperty();
    
    private final ObjectProperty<Cliente> cliente = new SimpleObjectProperty<>();
    private final ObjectProperty<EstadoTrabajo> estado = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();
    private final ObjectProperty<TerminoPago> terminoPago = new SimpleObjectProperty<>();
    
        //private final ObservableList<TrabajoProducto> productosDelTrabajoObservableList = FXCollections.observableArrayList();
        //private final ListProperty<TrabajoProducto> productosDelTrabajo = new SimpleListProperty<>(productosDelTrabajoObservableList);
    private ListProperty<TrabajoProducto> productosDelTrabajo = ListUtil.inicializarListProperty();
    private ListProperty<Pago> pagos = ListUtil.inicializarListProperty();
    
    
    public Trabajo() {
        
    }
    
    public Trabajo(LocalDate fechaAnticipo, Cliente cliente, List<TrabajoProducto> productosDelTrabajo){
        this.fechaAnticipo.set(fechaAnticipo);
        this.cliente.set(cliente);
        for (TrabajoProducto trabajoProducto : productosDelTrabajo) {
            this.privateAddProductoDeTrabajo(trabajoProducto);
        }
    }
    

    //Setters, getters and javafx properties
    
    //Id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    // otros
    //TrabajoProducto (productosDelTrabajo)
    @OneToMany(cascade=CascadeType.ALL, mappedBy="trabajo")
    public List<TrabajoProducto> getProductosDelTrabajo(){
        return productosDelTrabajo.get();
    }

    public void setProductosDelTrabajo(List<TrabajoProducto> productosDelTrabajo){
        ObservableList<TrabajoProducto> observableList = FXCollections.observableArrayList(productosDelTrabajo);
        this.productosDelTrabajo = new SimpleListProperty<>(observableList);
    }

    private void privateAddProductoDeTrabajo(TrabajoProducto productoDeTrabajo){
            productosDelTrabajo.get().add(productoDeTrabajo);
            productoDeTrabajo.setTrabajo(this);
            //this.actualizarPrecioTotalTrabajo();
    }
    
    public void addProductoDeTrabajo(TrabajoProducto productoDeTrabajo){
            this.privateAddProductoDeTrabajo(productoDeTrabajo);
    }
    
    //TrabajoProducto (productosDelTrabajo)
    @OneToMany(cascade=CascadeType.ALL, mappedBy="trabajo")
    public List<Pago> getPagos(){
        return pagos.get();
    }

    public void setPagos(List<Pago> pagosTrabajo){
        ObservableList<Pago> observableList = FXCollections.observableArrayList(pagosTrabajo);
        this.pagos = new SimpleListProperty<>(observableList);
    }
    
    public void addPago(Pago pagoTrabajo){
            pagos.get().add(pagoTrabajo);
            pagoTrabajo.setTrabajo(this);
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
    
    //tiempoEstimadoTermino
    public final void setTiempoEstimadoTermino(String value) {
        tiempoEstimadoTermino.set(value);
    }

    public final String getTiempoEstimadoTermino() {
        return tiempoEstimadoTermino.get();
    }

    public final StringProperty tiempoEstimadoTerminoProperty() {
        return tiempoEstimadoTermino;
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

    @ManyToOne
    public final Cliente getCliente() {
        return cliente.get();
    }

    public final ObjectProperty clienteProperty() {
        return cliente;
    }

    //Costo total
    public final void setCostoTotal(Double value) {
        costoTotal.set(value);
    }

    @Transient
    public final Double getCostoTotal() {
        return costoTotal.get();
    }

    public final DoubleProperty costoTotalProperty() {
        return costoTotal;
    }
    
    //Estado
    public final void setEstado(EstadoTrabajo value) {
        estado.set(value);
    }

    @ManyToOne
    public final EstadoTrabajo getEstado() {
        return estado.get();
    }

    public final ObjectProperty estadoProperty() {
        return estado;
    }
    
    //Color
    public final void setColor(Color value) {
        color.set(value);
    }

    @ManyToOne
    public final Color getColor() {
        return color.get();
    }

    public final ObjectProperty colorProperty() {
        return color;
    }
    
    //Termino de pago
    public final void setTerminoPago(TerminoPago value) {
        terminoPago.set(value);
    }

    @ManyToOne
    public final TerminoPago getTerminoPago() {
        return terminoPago.get();
    }

    public final ObjectProperty terminoPagoProperty() {
        return terminoPago;
    }
    
}
