/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.modelo.Color;
import com.wenbet.wenbettest2.modelo.Trabajo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TrabajoAgregarController extends MyInitializableAgregar<Trabajo> {

    @FXML
    private Label clienteLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private ComboBox<String> tiempoEstimadoCombo;
    @FXML
    private DatePicker fechaAnticipoDate;
    @FXML
    private DatePicker fechaInicioDate;
    @FXML
    private DatePicker fechaTerminoDate;
    @FXML
    private DatePicker fechaInstalacionDate;
    @FXML
    private TextArea comentariosTextArea;
    @FXML
    private ComboBox<String> terminoPagoCombo;
    
    public final String SEMANA0 = "Menos de 1 Semana";
    public final String SEMANA1 = "1 Semana";
    public final String SEMANA2 = "2 Semanas";
    public final String SEMANA3 = "3 Semanas";
    public final String SEMANA4 = "4 Semanas";
    public final String SEMANA5 = "Más de 1 mes";
    
    public final String TERMINO0 = "50% de anticipo y 50% al instalar";
    public final String TERMINO1 = "50% de anticipo y dos pagos de 25%";
    public final String TERMINO_OTRO = "Más de 1 mes";
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializar comboBox tiempo estimado de termino
        tiempoEstimadoCombo.getItems().addAll(
            SEMANA0,
            SEMANA1,
            SEMANA2,
            SEMANA3,
            SEMANA4,
            SEMANA5
        );
        
        //Inicializar comboBox terminos de pago
        terminoPagoCombo.getItems().addAll(
            TERMINO0,
            TERMINO1,
            TERMINO_OTRO
        );
        
        //Inicializar tabla de trabajosProducto
    }
    
    @Override
    protected boolean isInputValid() {
        return true;
//        String errorMessage = "";
//
//        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
//            errorMessage += "Nombre no valido\n"; 
//        }
//        if (marcaField.getText() == null || marcaField.getText().length() == 0) {
//            errorMessage += "Marca no valida\n"; 
//        }
//        
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Error al crear");
//            alert.setContentText(errorMessage);
//            alert.showAndWait();
//            return false;
//        }
    }

    @Override
    protected void fillData(Trabajo entidad) {
//        nombreField.setText(entidad.getNombre());
//        marcaField.setText(entidad.getMarca());
    }

    @Override
    protected void actualizarEntidad(Trabajo entidad) {
//        entidad.setNombre(nombreField.getText());
//        entidad.setMarca(marcaField.getText());
    }

    
    
}
