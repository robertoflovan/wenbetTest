package com.wenbet.wenbettest2;

import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.service.TrabajoService;
import com.wenbet.wenbettest2.test.TestDatosPrueba;
import com.wenbet.wenbettest2.util.HibernateUtil;
import com.wenbet.wenbettest2.util.VistaUtil;
import com.wenbet.wenbettest2.view.TipoProductoAgregarController;
import com.wenbet.wenbettest2.view.TipoProductoPrincipalController;
import com.wenbet.wenbettest2.view.TrabajoPrincipalController;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private final TipoProductoService tipoProductoService = new TipoProductoService();

    public MainApp() {
    }
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("WenbetTest");

        //Colocar datos de prueba en la base de datos
        TestDatosPrueba.datosPrueba();
        
        initRootLayout();

        //showTrabajoPrincipal();
        showTipoProductoPrincipal();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                HibernateUtil.getSessionFactory().close(); //TODO
            });
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la ventanta principal de trabajo
     */
    public void showTrabajoPrincipal() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/TrabajoPrincipal.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            TrabajoPrincipalController controller = loader.getController();
            controller.setMainApp(this);
            
            TrabajoService ts = new TrabajoService();
            List<Trabajo> trabajos = ts.ListarTrabajos();
            
            controller.setTrabajos(trabajos);
            
            // coloca la ventana de trabajo en la ventana principal (borderpane)
            rootLayout.setCenter(personOverview);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Muestra la ventanta principal de trabajo
     */
    public void showTipoProductoPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<TipoProducto> tipoProductos = tipoProductoService.ListarTipoProductos();
        VistaUtil.showVistaPrincipal(tipoProductos, "TipoProductoPrincipal", this);
    }

    /**
    * Opens a dialog to edit details for the specified tipoProducto. If the user
    * clicks OK, the changes are saved into the provided tipoProducto object and true
    * is returned.
    * 
    * @param tipoProducto the person object to be edited
    * @return true if the user clicked OK, false otherwise.
    */
   public boolean showTipoProductoEditDialog(TipoProducto tipoProducto) {
//       try {
//           // Load the fxml file and create a new stage for the popup dialog.
//           FXMLLoader loader = new FXMLLoader();
//           loader.setLocation(MainApp.class.getResource("/fxml/TipoProductoAgregar.fxml"));
//           AnchorPane page = (AnchorPane) loader.load();
//
//           // Create the dialog Stage.
//           Stage dialogStage = new Stage();
//           dialogStage.setTitle("Edit tipo producto");
//           dialogStage.initModality(Modality.WINDOW_MODAL);
//           dialogStage.initOwner(primaryStage);
//           Scene scene = new Scene(page);
//           dialogStage.setScene(scene);
//
//           // Set the person into the controller.
//           TipoProductoAgregarController controller = loader.getController();
//           controller.setDialogStage(dialogStage);
//           controller.setTipoProducto(tipoProducto);
//
//           // Show the dialog and wait until the user closes it
//           dialogStage.showAndWait();
//
//           return controller.isOkClicked();
//       } catch (IOException e) {
//           e.printStackTrace();
//           return false;
//       }
return false;
   }
    
    
    //Getters setters
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public BorderPane getRootLayout(){
        return rootLayout;
    }
    
    public TipoProductoService getTipoProductoService(){
        return tipoProductoService;
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    
    
    
    
}
