package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.IModel;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class SeleccionController extends MyInitializableSeleccionar<IModel> {

    @FXML
    private TableColumn<IModel, String> idColumn;
    @FXML
    private TableColumn<IModel, String> nombreColumn;
    
    
    
    public SeleccionController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> 
                new SimpleStringProperty(String.valueOf(cellData.getValue().toString()))
        );
    }
    
    @Override
    protected String[] datosTabla(IModel entidad) {
        String[] datos = new String[2];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.toString();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(IModel selected) {
        if (selected instanceof TipoProducto) {
            mainApp.getTipoProductoService().EliminarTipoProducto((TipoProducto) selected);
        }
    }

    @Override
    protected void guardarElementoDB(IModel selected) throws UnableToSaveException{
        if (selected instanceof TipoProducto) {
            mainApp.getTipoProductoService().GuardarTipoProducto((TipoProducto) selected);
        }
        
    }

    @Override
    protected void actualizarElementoDB(IModel selected) throws UnableToSaveException{
        if (selected instanceof TipoProducto) {
            mainApp.getTipoProductoService().ActualizarTipoProducto((TipoProducto) selected);
        }
    }

    @Override
    protected void actualizarEntidad(IModel entidad) {
        this.entidad = principalTable.getSelectionModel().getSelectedItem();
    }

     
  
   
    
}
