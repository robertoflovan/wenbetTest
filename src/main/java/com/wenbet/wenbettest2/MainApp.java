package com.wenbet.wenbettest2;

import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.test.TestDatosPrueba;
import com.wenbet.wenbettest2.view.TrabajoPrincipalController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("WenbetTest");

        TestDatosPrueba.datosPrueba();
        
        initRootLayout();

        showTrabajoPrincipal();
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

            // coloca la ventana de trabajo en la ventana principal (borderpane)
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            TrabajoPrincipalController controller = loader.getController();
            System.out.println("TrabajoPrincipalController controller = loader.getController();");
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    
    
    
    
}
