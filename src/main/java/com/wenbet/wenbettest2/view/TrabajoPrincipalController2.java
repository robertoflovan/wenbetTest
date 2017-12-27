/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import com.wenbet.wenbettest2.service.TrabajoService;
import com.wenbet.wenbettest2.test.testData;
import com.wenbet.wenbettest2.util.DateUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TrabajoPrincipalController2 extends MyInitializablePrincipal<Trabajo> {

    @FXML
    private Label idLabel;
    @FXML
    private Label clienteLabel;
    @FXML
    private Label fechaAnticipoLabel;
    @FXML
    private Label fechaInicioLabel;
    @FXML
    private Label fechaTerminoLabel;
    @FXML
    private Label fechaInstalacionLabel;
    
    
    @FXML
    private TableColumn<Trabajo, String> idColumn;
    @FXML
    private TableColumn<Trabajo, String> clienteColumn;
    @FXML
    private TableColumn<Trabajo, String> coloniaColumn;
    @FXML
    private TableColumn<Trabajo, LocalDate> anticipoColumn;
    @FXML
    private TableColumn<Trabajo, LocalDate> terminoColumn;
    @FXML
    private TableColumn<Trabajo, Number> costoTotalColumn;
    @FXML
    private TableColumn<Trabajo, Number> saldoColumn;

    @FXML
    protected TableView<TrabajoProducto> productosVendidosTable;
    @FXML
    private TableColumn<TrabajoProducto, String> productoColumn;
    @FXML
    private TableColumn<TrabajoProducto, Number> cantidadColumn;
    @FXML
    private TableColumn<TrabajoProducto, Number> precioColumn;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TrabajoPrincipalController2() {
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the person table with the two columns.
        
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        clienteColumn.setCellValueFactory(cellData -> cellData.getValue().getCliente().nombreProperty());
        coloniaColumn.setCellValueFactory(cellData -> cellData.getValue().getCliente().getDireccion().coloniaProperty());
        anticipoColumn.setCellValueFactory(cellData -> cellData.getValue().fechaAnticipoProperty());
        terminoColumn.setCellValueFactory(cellData -> cellData.getValue().fechaTerminoProperty());
        costoTotalColumn.setCellValueFactory(cellData -> cellData.getValue().costoTotalProperty());
        saldoColumn.setCellValueFactory(cellData -> cellData.getValue().costoTotalProperty());
        
        //Inicializar los datos de la tabla de productos del trabajo
        productoColumn.setCellValueFactory(cellData -> cellData.getValue().getProducto().nombreProperty());
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        
        // Listen for selection changes and show the job details when changed.
        principalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTrabajoDetails(newValue));
        
        
    }

    @Override
    protected String[] datosTabla(Trabajo trabajo) {
        String[] datos = new String[7];
        datos[0] = String.valueOf(trabajo.getId());
        datos[1] = trabajo.getCliente().getNombre();
        datos[2] = trabajo.getCliente().getDireccion().getColonia();
        datos[3] = DateUtil.format(trabajo.getFechaAnticipo());
        datos[4] = DateUtil.format(trabajo.getFechaAnticipo());
        datos[5] = String.valueOf(trabajo.calcularCostoTotal());
        datos[6] = null; //TODO saldo pendiente de trabajo
        return datos;
    }

    @Override
    protected void eliminarElementoDB(Trabajo selected) throws Exception {
        mainApp.getTrabajoService().EliminarTrabajo(selected);
    }

    @Override
    protected void guardarElementoDB(Trabajo selected) throws UnableToSaveException {
        mainApp.getTrabajoService().GuardarTrabajo(selected);
    }

    @Override
    protected void actualizarElementoDB(Trabajo selected) throws UnableToSaveException {
        mainApp.getTrabajoService().ActualizarTrabajo(selected);
    }

    /**
    * Fills all text fields to show details about the client.
    * If the specified client is null, all text fields are cleared.
    * 
    * @param person the person or null
    */
   private void showTrabajoDetails(Trabajo trabajo) {
       if (trabajo != null) {
           // Fill the labels with info from the client object.
           idLabel.setText(String.valueOf(trabajo.getId()));
           clienteLabel.setText(trabajo.getCliente().getNombre());
           fechaAnticipoLabel.setText(DateUtil.format(trabajo.getFechaAnticipo()));
           fechaInicioLabel.setText(DateUtil.format(trabajo.getFechaInicio()));
           fechaTerminoLabel.setText(DateUtil.format(trabajo.getFechaTermino()));
           fechaInstalacionLabel.setText(DateUtil.format(trabajo.getFechaInstalacion()));
           
            ObservableList<TrabajoProducto> observableList = FXCollections.observableArrayList(trabajo.getProductosDelTrabajo());
            ListProperty lp  = new SimpleListProperty<>(observableList);
            productosVendidosTable.setItems(lp);
           
       } else {
           // Fill the labels with info from the client object.
           idLabel.setText("");
           clienteLabel.setText("");
           fechaAnticipoLabel.setText("");
           fechaInicioLabel.setText("");
           fechaTerminoLabel.setText("");
           fechaInstalacionLabel.setText("");
           
            ObservableList<TrabajoProducto> observableList = FXCollections.observableArrayList();
            ListProperty lp  = new SimpleListProperty<>(observableList);
            productosVendidosTable.setItems(lp);
       }
   }
    
    
   
    
    
}
