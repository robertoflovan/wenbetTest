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
import java.util.List;
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
    protected String[] datosTabla(TipoProducto entidad) {
        String[] datos = new String[2];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(TipoProducto selected) {
        mainApp.getTipoProductoService().EliminarTipoProducto(selected);
    }

    @Override
    protected void guardarElementoDB(TipoProducto selected) throws UnableToSaveException{
        mainApp.getTipoProductoService().GuardarTipoProducto(selected);
    }

    @Override
    protected void actualizarElementoDB(TipoProducto selected) throws UnableToSaveException{
        mainApp.getTipoProductoService().ActualizarTipoProducto(selected);
    }

     
  
   
    
}
