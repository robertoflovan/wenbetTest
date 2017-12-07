/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.util.DialogUtil;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class ClientePrincipalController extends MyInitializablePrincipal<Cliente> {

    @FXML
    private TableColumn<Cliente, String> idColumn;
    @FXML
    private TableColumn<Cliente, String> nombreColumn;
    @FXML
    private TableColumn<Cliente, String> apellidoColumn;
    @FXML
    private TableColumn<Cliente, String> coloniaColumn;
    @FXML
    private TableColumn<Cliente, String> celularColumn;
    @FXML
    private TableColumn<Cliente, String> telefonoColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidoColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        coloniaColumn.setCellValueFactory(cellData -> cellData.getValue().getDireccion().coloniaProperty());
        celularColumn.setCellValueFactory(cellData -> cellData.getValue().celularProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
    }    

    @Override
    protected boolean compararDatosFiltro(Cliente entidad, String textoFiltro) {
        //Compare first name and last name of every person with filter text.
        String lowerCaseFilter = textoFiltro.toLowerCase();
        
        if (String.valueOf(entidad.getId()).contains(textoFiltro)) {
            return true;
        } else if (entidad.getNombre().toLowerCase().contains(textoFiltro)) {
            return true; 
        } else if (entidad.getApellido().toLowerCase().contains(textoFiltro)) {
            return true; 
        } else if (entidad.getDireccion().getColonia().toLowerCase().contains(textoFiltro)) {
            return true; 
        } else if (entidad.getCelular().toLowerCase().contains(textoFiltro)) {
            return true; 
        } else if (entidad.getTelefono().toLowerCase().contains(textoFiltro)) {
            return true;
        }
        return false; // Does not match.
    }

    @Override
    protected boolean eliminarElementoDB(Cliente selected) {
        boolean success = true;
        try {
            mainApp.getClienteService().EliminarCliente(selected);
        } catch (Exception e) {
            success = false;
            
            if (e.getCause()!=null && e.getCause().toString().contains("Cannot delete or update a parent row: a foreign key constraint fails")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al eliminar");
            alert.setContentText("No se puede eliminar, existen datos haciendo referencia, favor de eliminarlos primero");
            alert.showAndWait();
            } else {
                DialogUtil.showExceptionDialog(e);
            }
        }
        return success;
    }

    @Override
    protected boolean guardarElementoDB(Cliente selected) {
        boolean success = true;
        try {
            mainApp.getClienteService().GuardarCliente(selected);
        } catch (UnableToSaveException ex) {
            success = false;
            DialogUtil.showExceptionDialog(ex);
        }
        return success;
    }

    @Override
    protected boolean actualizarElementoDB(Cliente selected) {
        boolean success = true;
        try {
            mainApp.getClienteService().ActualizarCliente(selected);
        } catch (UnableToSaveException ex) {
            success = false;
            DialogUtil.showExceptionDialog(ex);
        }
        return success;
    }
    
}
