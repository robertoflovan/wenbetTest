package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Actividad;
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
public class ActividadPrincipalController extends MyInitializablePrincipal<Actividad> {

    @FXML
    private TableColumn<Actividad, String> idColumn;
    @FXML
    private TableColumn<Actividad, String> nombreColumn;
    
    public ActividadPrincipalController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }
    
    @Override
    protected String[] datosTabla(Actividad entidad) {
        String[] datos = new String[2];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(Actividad selected) {
        mainApp.getActividadService().EliminarActividad(selected);
    }

    @Override
    protected boolean guardarElementoDB(Actividad selected) throws UnableToSaveException{
        long id = mainApp.getActividadService().GuardarActividad(selected);
        return id!=0; //Si el ID es 0 es que hay un problema al guardar en la base de datos
    }

    @Override
    protected void actualizarElementoDB(Actividad selected) throws UnableToSaveException{
        mainApp.getActividadService().ActualizarActividad(selected);
    }

     
  
   
    
}
