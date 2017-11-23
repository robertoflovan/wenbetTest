/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.modelo;

import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.DoubleProperty;
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
class Trabajo {
    
    private long id;
    
    private final ObjectProperty<LocalDate> fechaAnticipo = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInicio = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaTermino = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fechaInstalacion = new SimpleObjectProperty<>();
    
    private final DoubleProperty precioTotal = new SimpleDoubleProperty();
    private final StringProperty color = new SimpleStringProperty();
    private final StringProperty comentarios = new SimpleStringProperty();
    
    private final ObjectProperty<Cliente> cliente = new SimpleObjectProperty<>();
    
    private List<TrabajoProducto> productosDelTrabajo;

    
    
    
    
}
