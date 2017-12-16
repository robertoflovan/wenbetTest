/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import java.io.Serializable;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 *
 * @author Roberto
 * @param <T>
 */
public abstract class MyInitializableSeleccionar<T extends Serializable> extends MyInitializablePrincipal<T>{
    
    /**
     * Actualiza la entidad con todos los datos obtenidos del usuario mediante la vista
     * @param entidad que se actualizará
     */
    protected abstract void actualizarEntidad(T entidad);
    
    
    protected Stage dialogStage;
    protected boolean okClicked = false;
    protected T entidad;
    
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
    
//    /**
//     * Sets the entity on the view an fill the components with the entity data
//     * @param entidad 
//     */
//    public void setEntidad(T entidad) {
//        this.entidad = entidad;
//    }
    
    public T getEntidad(){
        return this.entidad;
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {

            actualizarEntidad(this.entidad);

            okClicked = true;
            dialogStage.close();
        
    }

    
}
