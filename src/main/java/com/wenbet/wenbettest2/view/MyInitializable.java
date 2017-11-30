/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import java.io.Serializable;
import java.util.List;
import javafx.fxml.Initializable;

/**
 *
 * @author Roberto
 * @param <T> Tabla de la cual colocarán los datos
 */
public interface MyInitializable<T extends Serializable> extends Initializable{
    
    public void setData(List<T> data);
    
}
