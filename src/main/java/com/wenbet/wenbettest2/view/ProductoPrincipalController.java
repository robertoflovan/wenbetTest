package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Producto;
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
public class ProductoPrincipalController extends MyInitializablePrincipal<Producto> {

    @FXML
    private TableColumn<Producto, String> idColumn;
    @FXML
    private TableColumn<Producto, String> nombreColumn;
    @FXML
    private TableColumn<Producto, String> tipoProductoColumn;
    
    public ProductoPrincipalController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        tipoProductoColumn.setCellValueFactory(cellData -> cellData.getValue().getTipoProducto().nombreProperty());
    }
    
    @Override
    protected String[] datosTabla(Producto entidad) {
        String[] datos = new String[3];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        datos[2] = entidad.getTipoProducto().getNombre();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(Producto selected) {
        mainApp.getProductoService().EliminarProducto(selected);
    }

    @Override
    protected void guardarElementoDB(Producto selected) throws UnableToSaveException{
        mainApp.getProductoService().GuardarProducto(selected);
    }

    @Override
    protected void actualizarElementoDB(Producto selected) throws UnableToSaveException{
        mainApp.getProductoService().ActualizarProducto(selected);
    }

     
  
   
    
}
