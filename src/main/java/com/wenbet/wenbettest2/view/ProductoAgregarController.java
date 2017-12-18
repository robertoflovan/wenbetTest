/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.util.VistaUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class ProductoAgregarController extends MyInitializableAgregar<Producto> {

    @FXML
    private TextField nombreField;
    @FXML
    private Label tipoProductoLabel;
    
    private TipoProducto tipoProducto;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoProductoLabel.setText("");
    }
    
    @Override
    protected boolean isInputValid() {
        String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "Nombre no valido\n"; 
        }
        if (tipoProductoLabel.getText() == null || tipoProductoLabel.getText().length() == 0 || tipoProducto == null) {
            errorMessage += "tipo de producto no valido\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al crear");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    @Override
    protected void fillData(Producto entidad) {
        nombreField.setText(entidad.getNombre());
        tipoProductoLabel.setText(entidad.getTipoProducto().getNombre());
        this.tipoProducto = entidad.getTipoProducto();
    }

    @Override
    protected void actualizarEntidad(Producto entidad) {
        entidad.setNombre(nombreField.getText());
        entidad.setTipoProducto(this.tipoProducto);
    }


   @FXML
   private void handleAddTipoProducto() {
       AnchorPane overview = null;
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/TipoProductoPrincipal.fxml"));
            overview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            MyInitializablePrincipal controller = loader.getController();
            
            TipoProductoService tipoProductoService = new TipoProductoService();
            
            
            controller.setData(tipoProductoService.ListarTipoProductos());
            controller.setNombreEntidad("TipoProducto");
            controller.setClass(TipoProducto.class);
            
            
            // Create the dialog Stage.
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Editar");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(mainApp.getPrimaryStage());
           Scene scene = new Scene(overview);
           dialogStage.setScene(scene);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   
   @FXML
   public void handleSeleccionarProducto(){
       VistaUtil.showVistaSeleccion(mainApp.getProductoService().ListarProductos(), "TipoProducto", TipoProducto.class, mainApp);
   }
    
}
