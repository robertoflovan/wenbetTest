/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TipoProductoAgregarController extends MyInitializableAgregar<TipoProducto> {

    @FXML
    private TextField nombreField;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @Override
    protected boolean isInputValid() {
        String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "Nombre no valido\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al crear");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    @Override
    protected void fillData(TipoProducto entidad) {
        nombreField.setText(entidad.getNombre());
    }

    @Override
    protected void actualizarEntidad(TipoProducto entidad) {
        entidad.setNombre(nombreField.getText());
    }

    
    
}
