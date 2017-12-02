package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TipoProductoPrincipalController implements MyInitializable<TipoProducto> {

    @FXML
    private TableView<TipoProducto> tipoProductoTable;
    
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
    public void setData(List<TipoProducto> data) {
        ObservableList<TipoProducto> tipoProductos = FXCollections.observableArrayList(data);
        tipoProductoTable.setItems(tipoProductos);
    }
    
}
