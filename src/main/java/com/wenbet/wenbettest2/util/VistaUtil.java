/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.util;

import com.wenbet.wenbettest2.MainApp;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.view.MyInitializable;
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
    
    
    /**
     * Método para mostrar una nueva vista principal, la cual tendrá una tabla que mostrará datos que se indiquen
     * @param <T> Controlador de la vista que se mostrará
     * @param <Entity> Entidad de la vista que se mostrará
     * @param data datos que se mostrarán en la tabla
     * @param tabla Nombre de la tabla
     * @return 
     */
    public static <T extends MyInitializable, Entity> AnchorPane showVistaPrincipal(List<Entity> data, String tabla) {
        AnchorPane overview = null;
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/TipoProductoPrincipal.fxml"));
            overview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            T controller = loader.getController();
            
            //TipoProductoService tps = new TipoProductoService();
            //List<TipoProducto> tipoProductos = tps.ListarTipoProductos();
            
            controller.setData(data);
            
            // coloca la ventana de trabajo en la ventana principal (borderpane)
            //rootLayout.setCenter(personOverview);
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return overview;
    }
    
}
