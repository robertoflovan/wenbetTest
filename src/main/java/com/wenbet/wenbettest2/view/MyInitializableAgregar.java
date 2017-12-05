/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import java.io.Serializable;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author Roberto
 * @param <T>
 */
public abstract class MyInitializableAgregar<T extends Serializable> implements Initializable{
    
    public abstract void setEntidad(T entidad);
    
    protected Stage dialogStage;
    protected boolean okClicked = false;
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
}
