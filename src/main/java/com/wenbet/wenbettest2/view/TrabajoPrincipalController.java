/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.service.TrabajoService;
import com.wenbet.wenbettest2.test.testData;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
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
public class TrabajoPrincipalController implements Initializable {

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
    private TableView<Trabajo> trabajoTable;
    
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

    // Reference to the main application.
    private MainApp mainApp;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TrabajoPrincipalController() {
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
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table TODO
//        TrabajoService ts = new TrabajoService();
//        ObservableList<Trabajo> data = FXCollections.observableArrayList(ts.ListarTrabajos());
//        System.out.println(ts.ListarTrabajos().size());
//        
//        trabajoTable.setItems(data);
    }
    
    public void setTrabajos(List<Trabajo> trabajos){
        ObservableList<Trabajo> data = FXCollections.observableArrayList(trabajos);
        trabajoTable.setItems(data);
    }

    

    
    
}
