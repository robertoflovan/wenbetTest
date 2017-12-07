/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.util.VistaUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Roberto
 * @param <T> Tabla de la cual colocarán los datos
 */
public abstract class MyInitializablePrincipal<T extends Serializable> implements Initializable{
    
    protected abstract boolean compararDatosFiltro(T entidad, String textoFiltro);
    
    @FXML
    protected TextField filterField;
    
    public void setData(List<T> data){
        for (T t : data) {
            masterData.add(t);
        }
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<T> filteredData = new FilteredList<>(masterData, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(entidad -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                int num = principalTable.getColumns().size();
                
                //ArrayList<String>
                
                return compararDatosFiltro(entidad, newValue);

//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (tipoProducto.getNombre().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                }
//                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<T> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(principalTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        principalTable.setItems(sortedData);
    }
    
    protected abstract boolean eliminarElementoDB(T selected);
    
    protected abstract boolean guardarElementoDB(T selected);
    
    protected abstract boolean actualizarElementoDB(T selected);
    
    protected ObservableList<T> masterData = FXCollections.observableArrayList();
    
    protected MainApp mainApp;
    
    protected String nombreEntidad;
    
    protected Class<T> clase;
    
    public void setNombreEntidad(String nombreEntidad){
        this.nombreEntidad = nombreEntidad;
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
    public void setClass(Class<T> clase){
        this.clase = clase;
    }
    
    @FXML
    protected TableView<T> principalTable;
    
    protected boolean showAgregarDialog(T entidad){
       return VistaUtil.showAgregarDialog(entidad, nombreEntidad, mainApp);
    }
    
    /**
    * Called when the user clicks the new button. Opens a dialog to edit
    * details for a new person.
    */
   @FXML
   private void handleNew() {
       T temp = null;
        try {
            temp = clase.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MyInitializablePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       boolean okClicked = showAgregarDialog(temp);
       if (okClicked) {
           if (guardarElementoDB(temp)) {
                masterData.add(temp);
           }
       }
   }
   
   /**
    * Called when the user clicks the edit button. Opens a dialog to edit
    * details for the selected person.
    */
   @FXML
   private void handleEdit() {
       T selected = principalTable.getSelectionModel().getSelectedItem();
       if (selected != null) {
           boolean okClicked = showAgregarDialog(selected);
           if (okClicked) {
               actualizarElementoDB(selected);
           }

       } else {
           // Nothing selected.
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Error al editar");
           alert.setContentText("No se ha seleccionado nada para editar");
           alert.showAndWait();
       }
   }
    
    @FXML
    protected void handleDelete() {
       T selected = principalTable.getSelectionModel().getSelectedItem();
       if (selected != null) {
            if (eliminarElementoDB(selected)) {
               masterData.remove(selected);
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
