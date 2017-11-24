/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representación de la tabla <b>Direccion</b> en la BD, la clase será un Bean para javaFx con anotaciones para hibernate.
 * Indica la dirección de persona o negocio
 * <br> <i> - Relación unidireccional uno a uno con {@link Trabajador} (Esta clase no conoce la dirección) </i>
 * <br> <i> - Relación unidireccional uno a uno con {@link Proveedor} (Esta clase no conoce la dirección) </i>
 * <br> <i> - Relación unidireccional uno a uno con {@link Cliente} (Esta clase no conoce la dirección) </i>
 * @author Roberto
 */
public class Direccion {
    
    private long id;
    private final StringProperty ciudad = new SimpleStringProperty();
    private final StringProperty colonia= new SimpleStringProperty(); //TODO
    private final StringProperty calle= new SimpleStringProperty();
    private final StringProperty numero= new SimpleStringProperty();

    private Direccion() {
    }
    
    public Direccion(String ciudad, String colonia, String calle, String numero) {
        this.ciudad.set(ciudad);
        this.colonia.set(colonia);
        this.calle.set(calle);
        this.numero.set(numero);
    }
    
    //Getters, setters and javafx properties

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public final void setCiudad(String value) {
        ciudad.set(value);
    }

    public final String getCiudad() {
        return ciudad.get();
    }

    public final StringProperty ciudadProperty() {
        return ciudad;
    }

    public final void setColonia(String value) {
        colonia.set(value);
    }

    public final String getColonia() {
        return colonia.get();
    }

    public final StringProperty coloniaProperty() {
        return colonia;
    }

    public final void setCalle(String value) {
        calle.set(value);
    }

    public final String getCalle() {
        return calle.get();
    }

    public final StringProperty calleProperty() {
        return calle;
    }

    public final void setNumero(String value) {
        numero.set(value);
    }

    public final String getNumero() {
        return numero.get();
    }

    public final StringProperty numeroProperty() {
        return numero;
    }
    
    
    
}
