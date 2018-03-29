package com.wenbet.wenbettest2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.wenbet.wenbettest2.exception.UnableToSaveException;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Color;
import com.wenbet.wenbettest2.modelo.IModel;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TerminoPago;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class SeleccionController extends MyInitializableSeleccionar<IModel> {

    @FXML
    private TableColumn<IModel, String> idColumn;
    @FXML
    private TableColumn<IModel, String> nombreColumn;
    
    
    
    public SeleccionController() {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        nombreColumn.setCellValueFactory(cellData -> 
                new SimpleStringProperty(String.valueOf(cellData.getValue().toString()))
        );
    }
    
    @Override
    protected String[] datosTabla(IModel entidad) {
        String[] datos = new String[2];
        datos[0] = String.valueOf(entidad.getId());
        datos[1] = entidad.toString();
        return datos;
    }
    
    @Override
    public void eliminarElementoDB(IModel selected) {
        if (selected instanceof TipoProducto) {
            mainApp.getTipoProductoService().EliminarTipoProducto((TipoProducto) selected);
        }
    }

    @Override
    protected boolean guardarElementoDB(IModel selected) throws UnableToSaveException{
        long id = 0;
        if (selected instanceof TipoProducto) {
            id = mainApp.getTipoProductoService().GuardarTipoProducto((TipoProducto) selected);
        } else if (selected instanceof Producto) {
            id = mainApp.getProductoService().GuardarProducto((Producto) selected);
        } else if (selected instanceof Cliente) {
            id = mainApp.getClienteService().GuardarCliente((Cliente) selected);
        } else if (selected instanceof Color) {
            id = mainApp.getColorService().GuardarColor((Color) selected);
        } else if (selected instanceof TerminoPago) {
            id = mainApp.getTerminoPagoService().GuardarTerminoPago((TerminoPago) selected);
        } 
        return id!=0;
    }

    @Override
    protected void actualizarElementoDB(IModel selected) throws UnableToSaveException{
        if (selected instanceof TipoProducto) {
            mainApp.getTipoProductoService().ActualizarTipoProducto((TipoProducto) selected);
        }
    }

//    @Override
//    protected void actualizarEntidad(IModel entidad) {
//        this.entidad = principalTable.getSelectionModel().getSelectedItem();
//    }

     
  
   
    
}
