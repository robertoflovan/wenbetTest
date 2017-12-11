 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.util.DateUtil;
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
public class TrabajadorPrincipalController extends MyInitializablePrincipal<Trabajador> {

    @FXML
    private TableColumn<Trabajador, String> idColumn;
    @FXML
    private TableColumn<Trabajador, String> nombreColumn;
    @FXML
    private TableColumn<Trabajador, String> apellidoColumn;
    @FXML
    private TableColumn<Trabajador, String> puestoColumn;
    @FXML
    private TableColumn<Trabajador, String> fechaAltaColumn;
    
    @FXML
    private Label idLabel;
    @FXML
    private Label nombreLabel;
    @FXML
    private Label apellidoLabel;
    @FXML
    private Label puestoLabel;
    @FXML
    private Label fechaAltaLabel;
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
        puestoColumn.setCellValueFactory(cellData -> cellData.getValue().puestoProperty());
        fechaAltaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaAltaProperty());
        
        // Clear client details.
        showTrabajadorDetails(null);

        // Listen for selection changes and show the person details when changed.
        principalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTrabajadorDetails(newValue));
        
    }    

     @Override
    protected String[] datosTabla(Trabajador entidad) {
        String[] datos = new String[5];
        
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.getNombre();
        datos[2] = entidad.getApellido();
        datos[3] = entidad.getPuesto();
        datos[4] = DateUtil.format(entidad.getFechaAlta());
        return datos;
    }
    
    @Override
    protected void eliminarElementoDB(Trabajador selected) throws Exception {
            mainApp.getTrabajadorService().EliminarTrabajador(selected);
    }

    @Override
    protected void guardarElementoDB(Trabajador selected) throws UnableToSaveException {
            mainApp.getTrabajadorService().GuardarTrabajador(selected);
    }

    @Override
    protected void actualizarElementoDB(Trabajador selected) throws UnableToSaveException {
            mainApp.getTrabajadorService().ActualizarTrabajador(selected);
    }
    
    /**
    * Fills all text fields to show details about the client.
    * If the specified client is null, all text fields are cleared.
    * 
    * @param person the person or null
    */
   private void showTrabajadorDetails(Trabajador trabajador) {
       if (trabajador != null) {
           // Fill the labels with info from the client object.
           idLabel.setText(String.valueOf(trabajador.getId()));
           nombreLabel.setText(trabajador.getNombre());
           apellidoLabel.setText(trabajador.getApellido());
           puestoLabel.setText(trabajador.getPuesto());
           
           fechaAltaLabel.setText(DateUtil.format(trabajador.getFechaAlta()));
           
           comentariosTextArea.setText(trabajador.getComentarios());
           ciudadLabel.setText(trabajador.getDireccion().getCiudad());
           coloniaLabel.setText(trabajador.getDireccion().getColonia());
           calleLabel.setText(trabajador.getDireccion().getCalle());
           numeroLabel.setText(trabajador.getDireccion().getNumero());

           // TODO: We need a way to convert the birthday into a String! 
           // birthdayLabel.setText(...);
       } else {
           // Person is null, remove all the text.
           idLabel.setText("");
           nombreLabel.setText("");
           apellidoLabel.setText("");
           puestoLabel.setText("");
           
           fechaAltaLabel.setText("");
           
           comentariosTextArea.setText("");
           ciudadLabel.setText("");
           coloniaLabel.setText("");
           calleLabel.setText("");
           numeroLabel.setText("");
       }
   }
    
}
