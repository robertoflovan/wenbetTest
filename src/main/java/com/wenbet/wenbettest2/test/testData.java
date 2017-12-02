/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.test;

import java.io.Serializable;
import java.util.List;
import javafx.fxml.Initializable;

/**
 *
 * @author Roberto
 * @param <T>
 */
public interface testData<T extends Serializable> extends Initializable{
    
    public <T> void setData(List<T> data);
    
}
