/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *  Representación de la tabla <b>Trabajador</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * <br> <i> - Relación unidireccional uno a uno {@link Direccion} (Sólo esta clase conoce la relación) </i>
 * <br> <i> - Relación unidireccional uno a muchos con {@link HoraTrabajada} (Esta clase no conoce la relación) </i>
 * @author Roberto
 */
@Entity
public class Trabajador implements Serializable{
    
    private long id;
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty puesto = new SimpleStringProperty();
    private final StringProperty comentarios = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> fechaAlta = new SimpleObjectProperty<>();
    
    private final ObjectProperty<Direccion> direccion = new SimpleObjectProperty<>();

    public Trabajador() {
    }
    
    public Trabajador(String nombre, String puesto, String comentarios, LocalDate fechaAlta, Direccion direccion) {
        this.nombre.set(nombre);
        this.puesto.set(puesto);
        this.comentarios.set(comentarios);
        this.fechaAlta.set(fechaAlta);
        
        this.direccion.set(direccion);
    }
    
    //Getters, setters and properties
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId(){
        return id;
    }

    public void setId(long id){
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

    public final void setPuesto(String value) {
        puesto.set(value);
    }

    public final String getPuesto() {
        return puesto.get();
    }

    public final StringProperty puestoProperty() {
        return puesto;
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

    //<LocalDate> fechaAlta
    public final void setFechaAlta(LocalDate value) {
        fechaAlta.set(value);
    }

    public final LocalDate getFechaAlta() {
        return fechaAlta.get();
    }

    public final ObjectProperty fechaAltaProperty() {
        return fechaAlta;
    }
    
    //<Direccion> direccion
    public final void setDireccion(Direccion value) {
        direccion.set(value);
    }

    @OneToOne(cascade={CascadeType.ALL}) 
    public final Direccion getDireccion() {
        return direccion.get();
    }

    public final ObjectProperty direccionProperty() {
        return direccion;
    }
}
