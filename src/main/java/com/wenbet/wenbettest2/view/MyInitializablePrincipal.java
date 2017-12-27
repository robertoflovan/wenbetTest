/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.util.DialogUtil;
import com.wenbet.wenbettest2.util.VistaUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
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
    
    
    //Actualización para agregar en ventana
    /**
     * Meotod utilizado para el filtro de la tabla, se debe devolver un arreglo de string con todos los datos de las columnas de la tabla en orden
     * @param entidad la entidad relacionada a la tabla principal
     * @return arreglo de string que contiene los datos de las celdas de la tabla principal
     */
    protected abstract String[] datosTabla(T entidad);
   
    
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
    
    private boolean compararDatosFiltro(T entidad, String textoFiltro){
        //Compare first name and last name of every person with filter text.
        String lowerCaseFilter = textoFiltro.toLowerCase();
        
        String[] datosTabla = datosTabla(entidad);
        
        for (String string : datosTabla) {
            if (string != null && string.toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
        }
        
        
//        if (entidad.getNombre().toLowerCase().contains(lowerCaseFilter)) {
//            return true; 
//        } else if (String.valueOf(entidad.getId()).contains(lowerCaseFilter)) {
//            return true;
//        }
        return false;// Does not match.
    }
    
    protected abstract void eliminarElementoDB(T selected) throws Exception;
    
    protected abstract void guardarElementoDB(T selected) throws UnableToSaveException;
    
    protected abstract void actualizarElementoDB(T selected) throws UnableToSaveException;
    
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
           if (guardarElemento(temp)) {
                masterData.add(temp);
           }
       }
   }
   
   private boolean guardarElemento(T entidad){
       boolean success = true;
        try {
            guardarElementoDB(entidad);
        } catch (UnableToSaveException ex) {
            success = false;
            DialogUtil.showExceptionDialog(ex);
        }
        return success;
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
               actualizarElemento(selected);
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
   
   private boolean actualizarElemento(T entidad){
       boolean success = true;
        try {
            //mainApp.getTipoProductoService().ActualizarTipoProducto(selected);
            actualizarElementoDB(entidad);
        } catch (UnableToSaveException ex) {
            success = false;
            DialogUtil.showExceptionDialog(ex);
        }
        return success;
   }
    
    @FXML
    protected void handleDelete() {
       T selected = principalTable.getSelectionModel().getSelectedItem();
       if (selected != null) {
            if (eliminarElemento(selected)) {
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
    
   private boolean eliminarElemento(T entidad){
       boolean success = true;
        try {
            //mainApp.getTipoProductoService().EliminarTipoProducto(selected);
            eliminarElementoDB(entidad);
        } catch (Exception e) {
            success = false;
            
            if (e.getCause()!=null && e.getCause().toString().contains("Cannot delete or update a parent row: a foreign key constraint fails")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al eliminar");
            alert.setContentText("No se puede eliminar, existen datos haciendo referencia, favor de eliminarlos primero");
            alert.showAndWait();
            } else {
                DialogUtil.showExceptionDialog(e);
            }
            
        }
        return success;
   }
    
    
    
}
