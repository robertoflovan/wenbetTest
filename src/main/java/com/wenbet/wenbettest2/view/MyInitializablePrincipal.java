/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import java.io.Serializable;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author Roberto
 * @param <T> Tabla de la cual colocarán los datos
 */
public abstract class MyInitializablePrincipal<T extends Serializable> implements Initializable{
    
    public abstract void setData(List<T> data);
    
    public abstract void eliminarElementoDB(T selected);
    
    protected MainApp mainApp;
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
    @FXML
    protected TableView<T> principalTable;
    
    @FXML
    protected void handleDelete() {
       T selected = principalTable.getSelectionModel().getSelectedItem();
       if (selected != null) {
            eliminarElementoDB(selected);
            principalTable.getItems().remove(selected);
       } else {
           // Nothing selected.
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Error al eliminar");
           alert.setContentText("No se ha seleccionado nada para eliminar");
           alert.showAndWait();
       }
       
   }
    
}
