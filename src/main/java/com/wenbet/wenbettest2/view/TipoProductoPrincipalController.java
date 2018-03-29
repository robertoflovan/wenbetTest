package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
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
    protected boolean guardarElementoDB(TipoProducto selected) throws UnableToSaveException{
        long id = mainApp.getTipoProductoService().GuardarTipoProducto(selected);
        return id!=0;
    }

    @Override
    protected void actualizarElementoDB(TipoProducto selected) throws UnableToSaveException{
        mainApp.getTipoProductoService().ActualizarTipoProducto(selected);
    }

     
  
   
    
}
