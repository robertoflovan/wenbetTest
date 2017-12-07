package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.util.DialogUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TipoProductoPrincipalController extends MyInitializablePrincipal<TipoProducto> {

    @FXML
    private TableColumn<TipoProducto, String> idColumn;
    @FXML
    private TableColumn<TipoProducto, String> nombreColumn;
    
    public TipoProductoPrincipalController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        
        
    }
    
    @Override
    public boolean eliminarElementoDB(TipoProducto selected) {
        boolean success = true;
        try {
            mainApp.getTipoProductoService().EliminarTipoProducto(selected);
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
    protected boolean guardarElementoDB(TipoProducto selected) {
        boolean success = true;
        try {
            mainApp.getTipoProductoService().GuardarTipoProducto(selected);
        } catch (UnableToSaveException ex) {
            success = false;
            Logger.getLogger(TipoProductoPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    protected boolean actualizarElementoDB(TipoProducto selected) {
        boolean success = true;
        try {
            mainApp.getTipoProductoService().ActualizarTipoProducto(selected);
        } catch (UnableToSaveException ex) {
            success = false;
            Logger.getLogger(TipoProductoPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    protected boolean compararDatosFiltro(TipoProducto entidad, String textoFiltro) {
        //Compare first name and last name of every person with filter text.
        String lowerCaseFilter = textoFiltro.toLowerCase();
        
        if (entidad.getNombre().toLowerCase().contains(lowerCaseFilter)) {
            return true; 
        } else if (String.valueOf(entidad.getId()).contains(lowerCaseFilter)) {
            return true;
        }
        return false;// Does not match.
    }
   
   
    
}
