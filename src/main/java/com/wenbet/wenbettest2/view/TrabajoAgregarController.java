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
import com.wenbet.wenbettest2.modelo.TerminoPago;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.modelo.TrabajoProducto;
import com.wenbet.wenbettest2.util.ListUtil;
import com.wenbet.wenbettest2.util.VistaUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    //private ListProperty<TrabajoProducto> productos = ListUtil.inicializarListProperty();
    
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
        //return true;
        String errorMessage = "";

        if (clienteLabel.getText() == null || clienteLabel.getText().length() == 0) {
            errorMessage += "cliente no valido\n"; 
        }
        if (colorLabel.getText() == null || colorLabel.getText().length() == 0) {
            errorMessage += "Color no valido\n"; 
        }
//        if (fechaAnticipoDate.getValue() == null || fechaAnticipoDate.getValue().toString().length() == 0) {
//            errorMessage += "Fecha de anticipo no valida\n"; 
//        }
//        if (fechaInicioDate.getValue() == null || fechaInicioDate.getValue().toString().length() == 0) {
//            errorMessage += "Fecha de inicio no valida\n"; 
//        }
//        if (fechaTerminoDate.getValue() == null || fechaTerminoDate.getValue().toString().length() == 0) {
//            errorMessage += "Fecha de termino no valida\n"; 
//        }
//        if (fechaInstalacionDate.getValue() == null || fechaInstalacionDate.getValue().toString().length() == 0) {
//            errorMessage += "Fecha de instalación no valida\n"; 
//        }
        
        if (productosVendidosTable.getItems().isEmpty()) {
            errorMessage += "Se debe añadir almenos un producto\n"; 
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
    protected void fillData(Trabajo trabajo) {
        ObservableList<TrabajoProducto> observableList = FXCollections.observableArrayList(trabajo.getProductosDelTrabajo());
        ListProperty lp  = new SimpleListProperty<>(observableList);
        productosVendidosTable.setItems(lp);
        
        clienteLabel.setText(trabajo.getCliente().getNombre());
        this.cliente = trabajo.getCliente();
        colorLabel.setText(trabajo.getColor().getNombre());
        this.color = trabajo.getColor();
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

        entidad.setFechaAnticipo(fechaAnticipoDate.getValue());
        entidad.setFechaInicio(fechaInicioDate.getValue());
        entidad.setFechaTermino(fechaTerminoDate.getValue());
        entidad.setFechaInstalacion(fechaInstalacionDate.getValue());
        
        if (comentariosTextArea.getText() == null || comentariosTextArea.getText().length() == 0) {
            entidad.setComentarios(comentariosTextArea.getText());
        }else{
            entidad.setComentarios("");
        }
        
        entidad.setTiempoEstimadoTermino(tiempoEstimadoCombo.getSelectionModel().getSelectedItem());
        entidad.setCostoTotal(calcularCostoTotal());
        entidad.setCliente(cliente);
        entidad.setColor(color);
        
        //Antes de añadir los productos al trabajo, le decimos a los productos de qué trabajo son
        List<TrabajoProducto> productos = productosVendidosTable.getItems();
        productos.forEach((producto) -> {
            producto.setTrabajo(entidad);
        });
        
        entidad.setProductosDelTrabajo(productos);
        
        //50% de anticipo y 50% al instalar por default
        TerminoPago t = new TerminoPago(0, 2);
        if (terminoPagoCombo.getValue().equals(TERMINO1)) {
            //50% anticipo y dos pagos de 25%
            t = new TerminoPago(0, 3);
        }
        entidad.setTerminoPago(t);
        
        
        

    }
    
    private double calcularCostoTotal(){
        double res = 0;
        ObservableList<TrabajoProducto> productos = this.productosVendidosTable.getItems();
        for (TrabajoProducto producto : productos) {
            res+=producto.getPrecio();
        }
        return res;
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
    
    private Producto productoTemp = null;
    @FXML
    private Label productoLabel;
    
    @FXML
    private TextField cantidadProductoField;
    @FXML
    private TextField precioProductoField;
    
    
    @FXML
    private void handleSeleccionarProducto(){
        System.out.println("handleSeleccionarProducto");
        IModel p = VistaUtil.showVistaSeleccion(mainApp.getProductoService().ListarProductos(), "Producto", Producto.class, mainApp);
        if (p != null) {
           this.productoTemp = (Producto) p;
           productoLabel.setText(this.productoTemp.getNombre());
        }
        //Crear una variable de producto temporal y luego al precionar agregar tomarla con los datos de los otros campos para agregar a la tabla un nuevo producto de trabajo
        //Luego de agregarse la variable temporal será nula para estar lista para agregar un nuevo producto
        
//        IModel p = VistaUtil.showVistaSeleccion(mainApp.getProductoService().ListarProductos(), "Producto", Producto.class, mainApp);
//        if (p != null) {
//           Producto nuevoProducto = (Producto) p;
//           productosVendidosTable.getItems().add(nuevoProducto);
//           //clienteLabel.setText(this.cliente.getNombre());
//        }
    }
    
    @FXML
    private void handleAgregarProducto(){
        if (isProductValid()) {
            int cantidad = Integer.parseInt(cantidadProductoField.getText());
            double precio = Double.parseDouble(precioProductoField.getText());

            TrabajoProducto tp = new TrabajoProducto(cantidad, precio, productoTemp);
            

            //Añadir el nuevo producto a la tabla de productos vendidos
            productosVendidosTable.getItems().add(tp);
        }
    }
    
    @FXML
    private void handleEliminarProducto(){
        //TODO: No está actualizando los productos eliminados
        
        TrabajoProducto selected = productosVendidosTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productosVendidosTable.getItems().remove(selected);
       } else {
           // Nothing selected.
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Error al eliminar");
           alert.setContentText("No se ha seleccionado nada para eliminar");
           alert.showAndWait();
       }
    }
    
    private boolean isProductValid(){
        String errorMessage = "";
        
        if (productoLabel.getText() == null || productoLabel.getText().length() == 0) {
            errorMessage += "Producto no válido\n";
        }
        
        try {
            Integer.parseInt(cantidadProductoField.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Cantidad no válida\n";
        }
        
        try {
           Double.parseDouble(precioProductoField.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Precio no válido\n";
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
    
}
