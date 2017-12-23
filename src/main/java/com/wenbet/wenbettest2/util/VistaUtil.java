/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.util;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.modelo.IModel;
import com.wenbet.wenbettest2.view.MyInitializableAgregar;
import com.wenbet.wenbettest2.view.MyInitializablePrincipal;
import com.wenbet.wenbettest2.view.MyInitializableSeleccionar;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Roberto
 */
public class VistaUtil {
    
    
    /**
     * Método para mostrar una nueva vista principal, la cual tendrá una tabla que mostrará datos que se indiquen
     * @param <Entity> Entidad de la vista que se mostrará
     * @param data datos que se mostrarán en la tabla
     * @param nombreEntidad
     * @param mainApp mainApp
     * @param clase
     */
    public static <Entity extends Serializable> void showVistaPrincipal(List<Entity> data, String nombreEntidad, Class<Entity> clase, MainApp mainApp) {
        AnchorPane overview = null;
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/"+nombreEntidad+"Principal.fxml"));
            overview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            MyInitializablePrincipal controller = loader.getController();
            
            controller.setData(data);
            controller.setMainApp(mainApp);
            controller.setNombreEntidad(nombreEntidad);
            controller.setClass(clase);
            
            mainApp.getRootLayout().setCenter(overview);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return overview;
    }
    
    
    public static <Entity extends Serializable> boolean showAgregarDialog(Entity entidad, String fxml, MainApp mainApp) {
       try {
           // Load the fxml file and create a new stage for the popup dialog.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("/fxml/"+fxml+"Agregar.fxml"));
           AnchorPane page = (AnchorPane) loader.load();

           // Create the dialog Stage.
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Editar");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(mainApp.getPrimaryStage());
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);

           // Set the person into the controller.
           MyInitializableAgregar controller = loader.getController();
           controller.setDialogStage(dialogStage);
           controller.setEntidad(entidad);
           controller.setMainApp(mainApp);

           // Show the dialog and wait until the user closes it
           dialogStage.showAndWait();

           return controller.isOkClicked();
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
   }
    
    public static <Entity extends Serializable> IModel showVistaSeleccion(List<Entity> data, String nombreEntidad, Class<Entity> clase, MainApp mainApp) {
        AnchorPane overview = null;
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/Seleccion.fxml"));
            overview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            MyInitializableSeleccionar controller = loader.getController();
            
            controller.setData(data);
            controller.setMainApp(mainApp);
            controller.setNombreEntidad(nombreEntidad);
            controller.setClass(clase);
            
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Seleccionar");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(overview);
            dialogStage.setScene(scene);
           
            controller.setDialogStage(dialogStage);
            //controller.setEntidad(entidad);
            
            // Show the dialog and wait until the user closes it
           dialogStage.showAndWait();
           
           return controller.getEntidad();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}//Fin de la clase
