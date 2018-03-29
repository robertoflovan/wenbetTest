/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class RootLayoutController implements Initializable {

    MainApp mainApp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
    //Modulos
    @FXML
    private void handleMenuTrabajos(){
        mainApp.showTrabajoPrincipal();
    }
    @FXML
    private void handleMenuClientes(){
        mainApp.showClientePrincipal();
    }
    @FXML
    private void handleMenuTrabajadores(){
        mainApp.showTrabajadorPrincipal();
    }
    @FXML
    private void handleMenuProductos(){
        mainApp.showProductoPrincipal();
    }
    @FXML
    private void handleMenuTipoProducto(){
        mainApp.showTipoProductoPrincipal();
    }
    @FXML
    private void handleMenuColores(){
        mainApp.showColorPrincipal();
    }
    @FXML
    private void handleMenuActividades(){
        mainApp.showActividadPrincipal();
    }
    
}
