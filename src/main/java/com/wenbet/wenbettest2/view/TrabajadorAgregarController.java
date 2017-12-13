/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.modelo.Trabajador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TrabajadorAgregarController extends MyInitializableAgregar<Trabajador> {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField puestoField;
    @FXML
    private TextField telefonoField;
    @FXML
    private DatePicker fechaAltaDate;
    @FXML
    private TextField comentariosField;
    
    @FXML
    private TextField ciudadField;
    @FXML
    private TextField coloniaField;
    @FXML
    private TextField calleField;
    @FXML
    private TextField numeroField;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @Override
    protected void fillData(Trabajador entidad) {
        nombreField.setText(entidad.getNombre());
        apellidoField.setText(entidad.getApellido());
        puestoField.setText(entidad.getPuesto());
        telefonoField.setText(entidad.getTelefono());
        fechaAltaDate.setValue(entidad.getFechaAlta());
        comentariosField.setText(entidad.getComentarios());
        
        ciudadField.setText(entidad.getDireccion().getCiudad());
        coloniaField.setText(entidad.getDireccion().getColonia());
        calleField.setText(entidad.getDireccion().getCalle());
        numeroField.setText(entidad.getDireccion().getNumero());
    }

    @Override
    protected boolean isInputValid() {
    String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "Nombre no valido\n"; 
        }
        if (apellidoField.getText() == null || apellidoField.getText().length() == 0) {
            errorMessage += "Apellido no valido\n"; 
        }
        if (puestoField.getText() == null || puestoField.getText().length() == 0) {
            errorMessage += "Celular no valido\n"; 
        }
        if (telefonoField.getText() == null || telefonoField.getText().length() == 0) {
            errorMessage += "Telefono no valido\n"; 
        }
//        if (fechaAlta.getText() == null || correoField.getText().length() == 0) {
//            errorMessage += "Correo no valido\n"; 
//        }
        if (comentariosField.getText() == null || comentariosField.getText().length() == 0) {
            errorMessage += "Comentarios no valido\n"; 
        }
        
        if (ciudadField.getText() == null || ciudadField.getText().length() == 0) {
            errorMessage += "Ciudad no valida\n"; 
        }
        
        if (coloniaField.getText() == null || coloniaField.getText().length() == 0) {
            errorMessage += "Colonia no valido\n"; 
        }
        
        if (calleField.getText() == null || calleField.getText().length() == 0) {
            errorMessage += "Calle no valido\n"; 
        }
        
        if (numeroField.getText() == null || numeroField.getText().length() == 0) {
            errorMessage += "Numero no valido\n"; 
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
    protected void actualizarEntidad(Trabajador entidad) {
        entidad.setNombre(nombreField.getText());
        entidad.setApellido(apellidoField.getText());
        entidad.setPuesto(puestoField.getText());
        entidad.setTelefono(telefonoField.getText());
        entidad.setFechaAlta(fechaAltaDate.getValue());
        entidad.setComentarios(comentariosField.getText());
        
        entidad.getDireccion().setCiudad(ciudadField.getText());
        entidad.getDireccion().setColonia(coloniaField.getText());
        entidad.getDireccion().setCalle(calleField.getText());
        entidad.getDireccion().setNumero(numeroField.getText());
    }
    
}
