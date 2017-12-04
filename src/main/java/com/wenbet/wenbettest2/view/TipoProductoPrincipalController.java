package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.service.TipoProductoService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TipoProductoPrincipalController extends MyInitializablePrincipal<TipoProducto> {

    //@FXML
    //private TableView<TipoProducto> tipoProductoTable;
    
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
        principalTable.setItems(tipoProductos);
    }

    @Override
    public void eliminarElementoDB(TipoProducto selected) {
        mainApp.getTipoProductoService().EliminarTipoProducto(selected);
    }
    
    /**
    * Called when the user clicks the new button. Opens a dialog to edit
    * details for a new person.
    */
   @FXML
   private void handleNew() {
       TipoProducto tempPerson = new TipoProducto();
       boolean okClicked = mainApp.showTipoProductoEditDialog(tempPerson);
       if (okClicked) {//Agregar un nuevo tipoProducto a la vista
           principalTable.getItems().add(tempPerson);
       }
   }

   /**
    * Called when the user clicks the edit button. Opens a dialog to edit
    * details for the selected person.
    */
   @FXML
   private void handleEdit() {
       TipoProducto selectedPerson = principalTable.getSelectionModel().getSelectedItem();
       if (selectedPerson != null) {
           boolean okClicked = mainApp.showTipoProductoEditDialog(selectedPerson);
           if (okClicked) {//Se editó un tipoProducto
               //showPersonDetails(selectedPerson);
           }

       } else {
           // Nothing selected.
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Error al eliminar");
           alert.setContentText("No se ha seleccionado nada para eliminar");
           alert.showAndWait();
       }
   }
    
}
