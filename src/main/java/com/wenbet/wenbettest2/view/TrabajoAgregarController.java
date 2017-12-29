/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.view;

import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Color;
import com.wenbet.wenbettest2.modelo.IModel;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import com.wenbet.wenbettest2.util.ListUtil;
import com.wenbet.wenbettest2.util.VistaUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Roberto
 */
public class TrabajoAgregarController extends MyInitializableAgregar<Trabajo> {

    
    private Cliente cliente;
    private Color color;
    private ListProperty<TrabajoProducto> productos = ListUtil.inicializarListProperty();
    
    @FXML
    private Label clienteLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private ComboBox<String> tiempoEstimadoCombo;
    @FXML
    private DatePicker fechaAnticipoDate;
    @FXML
    private DatePicker fechaInicioDate;
    @FXML
    private DatePicker fechaTerminoDate;
    @FXML
    private DatePicker fechaInstalacionDate;
    @FXML
    private TextArea comentariosTextArea;
    @FXML
    private ComboBox<String> terminoPagoCombo;
    
    @FXML
    protected TableView<TrabajoProducto> productosVendidosTable;
    @FXML
    private TableColumn<TrabajoProducto, String> productoColumn;
    @FXML
    private TableColumn<TrabajoProducto, Number> cantidadColumn;
    @FXML
    private TableColumn<TrabajoProducto, Number> precioColumn;
    
    @FXML
    private Label anticipoDeLabel;
    @FXML
    private CheckBox anticipoDineroCheck;
    
    @FXML
    private GridPane terminoPagoGrid;
    
    public final String SEMANA0 = "Menos de 1 Semana";
    public final String SEMANA1 = "1 Semana";
    public final String SEMANA2 = "2 Semanas";
    public final String SEMANA3 = "3 Semanas";
    public final String SEMANA4 = "4 Semanas";
    public final String SEMANA5 = "Más de 1 mes";
    
    public final String TERMINO0 = "50% de anticipo y 50% al instalar";
    public final String TERMINO1 = "50% de anticipo y dos pagos de 25%";
    public final String TERMINO_OTRO = "Otro";
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializar comboBox tiempo estimado de termino
        tiempoEstimadoCombo.getItems().addAll(
            SEMANA0,
            SEMANA1,
            SEMANA2,
            SEMANA3,
            SEMANA4,
            SEMANA5
        );
        tiempoEstimadoCombo.getSelectionModel().select(SEMANA4);
        
        //Inicializar comboBox terminos de pago
        terminoPagoCombo.getItems().addAll(
            TERMINO0,
            TERMINO1,
            TERMINO_OTRO
        );
        terminoPagoCombo.getSelectionModel().selectFirst();
        
        //Inicializar tabla de trabajosProducto
        productoColumn.setCellValueFactory(cellData -> cellData.getValue().getProducto().nombreProperty());
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        
        //Ocultar seccion específica de término de pago
        terminoPagoGrid.setDisable(true);
        
        //Inicializar productos del trabajo
        //this.productos.setAll()
    }
    
    @FXML
    private void handleTerminoPagoCombo(){
        if (terminoPagoCombo.getSelectionModel().getSelectedItem().equals(TERMINO_OTRO)) {
            terminoPagoGrid.setDisable(false);
        }else{
            terminoPagoGrid.setDisable(true);
        }
    }
    
    @Override
    protected boolean isInputValid() {
        return true;
//        String errorMessage = "";
//
//        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
//            errorMessage += "Nombre no valido\n"; 
//        }
//        if (marcaField.getText() == null || marcaField.getText().length() == 0) {
//            errorMessage += "Marca no valida\n"; 
//        }
//        
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Error al crear");
//            alert.setContentText(errorMessage);
//            alert.showAndWait();
//            return false;
//        }
    }

    @Override
    protected void fillData(Trabajo trabajo) {
        ObservableList<TrabajoProducto> observableList = FXCollections.observableArrayList(trabajo.getProductosDelTrabajo());
        ListProperty lp  = new SimpleListProperty<>(observableList);
        productosVendidosTable.setItems(lp);
        
        clienteLabel.setText(trabajo.getCliente().getNombre());
        colorLabel.setText(trabajo.getColor().getNombre());
        //tiempoEstimadoCombo
        fechaAnticipoDate.setValue(trabajo.getFechaAnticipo());
        fechaInicioDate.setValue(trabajo.getFechaInicio());
        fechaTerminoDate.setValue(trabajo.getFechaTermino());
        fechaInstalacionDate.setValue(trabajo.getFechaInstalacion());
        comentariosTextArea.setText(trabajo.getComentarios());
        //terminoPagoCombo
        
        
        
//        nombreField.setText(entidad.getNombre());
//        marcaField.setText(entidad.getMarca());
    }

    @Override
    protected void actualizarEntidad(Trabajo entidad) {
//        entidad.setNombre(nombreField.getText());
//        entidad.setMarca(marcaField.getText());
    }

    @FXML
    private void handleSeleccionarCliente(){
       IModel c = VistaUtil.showVistaSeleccion(mainApp.getClienteService().ListarClientes(), "Cliente", Cliente.class, mainApp);
       if (c != null) {
           this.cliente = (Cliente) c;
           clienteLabel.setText(this.cliente.getNombre());
       }
    }
    
    @FXML
    private void handleSeleccionarColor(){
        IModel c = VistaUtil.showVistaSeleccion(mainApp.getColorService().ListarColores(), "Color", Color.class, mainApp);
        if (c != null) {
           this.color = (Color) c;
           colorLabel.setText(this.color.getNombre() + "(" + this.color.getMarca() + ")");
        }
    }
    
    @FXML
    private void handleAnticipoDinero(){
        if (anticipoDineroCheck.isSelected()) {
            anticipoDeLabel.setText("Anticipo de ($)");
        } else {
            anticipoDeLabel.setText("Anticipo de (%)");
        }
    }
    
    @FXML
    private void handleSeleccionarProducto(){
        //Crear una variable de producto temporal y luego al precionar agregar tomarla con los datos de los otros campos para agregar a la tabla un nuevo producto de trabajo
//        IModel p = VistaUtil.showVistaSeleccion(mainApp.getProductoService().ListarProductos(), "Producto", Producto.class, mainApp);
//        if (p != null) {
//           Producto nuevoProducto = (Producto) p;
//           productosVendidosTable.getItems().add(nuevoProducto);
//           //clienteLabel.setText(this.cliente.getNombre());
//        }
    }
    
}
