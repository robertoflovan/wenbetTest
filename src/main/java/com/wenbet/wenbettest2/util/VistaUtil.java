/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.util;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.view.TipoProductoPrincipalController;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Roberto
 */
public class VistaUtil {
    
    public static <T, P> void showTipoProductoPrincipal(List<P> data) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/TipoProductoPrincipal.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            T controller = loader.getController();
            
            //TipoProductoService tps = new TipoProductoService();
            //List<TipoProducto> tipoProductos = tps.ListarTipoProductos();
            
            //controller.setTipoProductos(data);
            
            // coloca la ventana de trabajo en la ventana principal (borderpane)
            //rootLayout.setCenter(personOverview);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
