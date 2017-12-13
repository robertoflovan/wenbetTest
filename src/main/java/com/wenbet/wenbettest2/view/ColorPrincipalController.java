package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Color;
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
public class ColorPrincipalController extends MyInitializablePrincipal<Color> {

    @FXML
    private TableColumn<Color, String> idColumn;
    @FXML
    private TableColumn<Color, String> nombreColumn;
    @FXML
    private TableColumn<Color, String> marcaColumn;
    
    public ColorPrincipalController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        marcaColumn.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());
    }
    
    @Override
    protected String[] datosTabla(Color entidad) {
        String[] datos = new String[3];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        datos[2] = entidad.getMarca();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(Color selected) {
        mainApp.getColorService().EliminarColor(selected);
    }

    @Override
    protected void guardarElementoDB(Color selected) throws UnableToSaveException{
        mainApp.getColorService().GuardarColor(selected);
    }

    @Override
    protected void actualizarElementoDB(Color selected) throws UnableToSaveException{
        mainApp.getColorService().ActualizarColor(selected);
    }

     
  
   
    
}
