/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.util;


import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Algunos métodos de ayuda para manejar listas y observableList
 * 
 * @author Roberto
 */
public class ListUtil {
    
    /**
     * Método para inicializar una variable de tipo ListProperty
     * @param <T> El objeto de cual será la lista
     * @return un objeto ListProperty inicializado con observableList
     */
    public static <T> ListProperty<T> inicializarListProperty(){
        ObservableList<T> observableList = FXCollections.observableArrayList();
        return new SimpleListProperty<>(observableList);
    }
    
    /**
     * Método para llenar un listProperty tomando una lista normal
     * @param <T> El objeto de la lista
     * @param listProperty La lista que se llenará
     * @param list La lista con la cual se llenará el listProperty
     */
    public static <T> void llenarListProperty(ListProperty<T> listProperty, List<T> list){
        for (T item : list) {
            listProperty.add(item);
        }
    }
    
}
