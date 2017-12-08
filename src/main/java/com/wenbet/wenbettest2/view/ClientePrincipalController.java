/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class ClientePrincipalController extends MyInitializablePrincipal<Cliente> {

    @FXML
    private TableColumn<Cliente, String> idColumn;
    @FXML
    private TableColumn<Cliente, String> nombreColumn;
    @FXML
    private TableColumn<Cliente, String> apellidoColumn;
    @FXML
    private TableColumn<Cliente, String> coloniaColumn;
    @FXML
    private TableColumn<Cliente, String> celularColumn;
    @FXML
    private TableColumn<Cliente, String> telefonoColumn;
    
    @FXML
    private Label idLabel;
    @FXML
    private Label nombreLabel;
    @FXML
    private Label apellidoLabel;
    @FXML
    private Label celularLabel;
    @FXML
    private Label telefonoLabel;
    @FXML
    private Label correoLabel;
    @FXML
    private TextArea comentariosTextArea;
    @FXML
    private Label ciudadLabel;
    @FXML
    private Label coloniaLabel;
    @FXML
    private Label calleLabel;
    @FXML
    private Label numeroLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidoColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        coloniaColumn.setCellValueFactory(cellData -> cellData.getValue().getDireccion().coloniaProperty());
        celularColumn.setCellValueFactory(cellData -> cellData.getValue().celularProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        
        // Clear client details.
        showClienteDetails(null);

        // Listen for selection changes and show the person details when changed.
        principalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClienteDetails(newValue));
        
    }    

     @Override
    protected String[] datosTabla(Cliente entidad) {
        String[] datos = new String[6];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        datos[2] = entidad.getApellido();
        datos[3] = entidad.getDireccion().getColonia();
        datos[4] = entidad.getCelular();
        datos[5] = entidad.getTelefono();
        return datos;
    }
    
    @Override
    protected void eliminarElementoDB(Cliente selected) throws Exception {
            mainApp.getClienteService().EliminarCliente(selected);
    }

    @Override
    protected void guardarElementoDB(Cliente selected) throws UnableToSaveException {
            mainApp.getClienteService().GuardarCliente(selected);
    }

    @Override
    protected void actualizarElementoDB(Cliente selected) throws UnableToSaveException {
            mainApp.getClienteService().ActualizarCliente(selected);
    }
    
    /**
    * Fills all text fields to show details about the client.
    * If the specified client is null, all text fields are cleared.
    * 
    * @param person the person or null
    */
   private void showClienteDetails(Cliente cliente) {
       if (cliente != null) {
           // Fill the labels with info from the client object.
           idLabel.setText(String.valueOf(cliente.getId()));
           nombreLabel.setText(cliente.getNombre());
           apellidoLabel.setText(cliente.getApellido());
           celularLabel.setText(cliente.getCelular());
           telefonoLabel.setText(cliente.getCelular());
           correoLabel.setText(cliente.getCorreo());
           comentariosTextArea.setText(cliente.getComentarios());
           ciudadLabel.setText(cliente.getDireccion().getCiudad());
           coloniaLabel.setText(cliente.getDireccion().getColonia());
           calleLabel.setText(cliente.getDireccion().getCalle());
           numeroLabel.setText(cliente.getDireccion().getNumero());

           // TODO: We need a way to convert the birthday into a String! 
           // birthdayLabel.setText(...);
       } else {
           // Person is null, remove all the text.
           idLabel.setText("");
           nombreLabel.setText("");
           apellidoLabel.setText("");
           celularLabel.setText("");
           telefonoLabel.setText("");
           correoLabel.setText("");
           comentariosTextArea.setText("");
           ciudadLabel.setText("");
           coloniaLabel.setText("");
           calleLabel.setText("");
           numeroLabel.setText("");
       }
   }
    
}
