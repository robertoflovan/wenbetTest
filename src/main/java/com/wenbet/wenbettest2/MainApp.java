package com.wenbet.wenbettest2;

import com.wenbet.wenbettest2.modelo.Actividad;
import com.wenbet.wenbettest2.modelo.Cliente;
import com.wenbet.wenbettest2.modelo.Color;
import com.wenbet.wenbettest2.modelo.Producto;
import com.wenbet.wenbettest2.modelo.TipoProducto;
import com.wenbet.wenbettest2.modelo.Trabajador;
import com.wenbet.wenbettest2.modelo.Trabajo;
import com.wenbet.wenbettest2.service.ActividadService;
import com.wenbet.wenbettest2.service.ClienteService;
import com.wenbet.wenbettest2.service.ColorService;
import com.wenbet.wenbettest2.service.ProductoService;
import com.wenbet.wenbettest2.service.TipoProductoService;
import com.wenbet.wenbettest2.service.TrabajadorService;
import com.wenbet.wenbettest2.service.TrabajoService;
import com.wenbet.wenbettest2.test.TestDatosPrueba;
import com.wenbet.wenbettest2.util.HibernateUtil;
import com.wenbet.wenbettest2.util.VistaUtil;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private final TipoProductoService tipoProductoService = new TipoProductoService();
    private final ClienteService clienteService = new ClienteService();
    private final TrabajadorService trabajadorService = new TrabajadorService();
    private final ColorService colorService = new ColorService();
    private final ActividadService actividadService = new ActividadService();
    private final ProductoService productoService = new ProductoService();
    private final TrabajoService trabajoService = new TrabajoService();

    public MainApp() {
        SQLServerDriver a = new SQLServerDriver();
    }
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("WenbetTest");

        //Colocar datos de prueba en la base de datos
        TestDatosPrueba.datosPrueba();
        
        initRootLayout();

        showTrabajoPrincipal();
        //showTipoProductoPrincipal();
        //showClientePrincipal();
        //showTrabajadorPrincipal();
        //showColorPrincipal();
        //showActividadPrincipal();
        //showProductoPrincipal();
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
        List<Trabajo> trabajos = trabajoService.ListarTrabajos();
        VistaUtil.showVistaPrincipal(trabajos, "Trabajo", Trabajo.class, this);
    }
    
    /**
     * Muestra la ventanta principal de trabajo
     */
    public void showTipoProductoPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<TipoProducto> tipoProductos = tipoProductoService.ListarTipoProductos();
        VistaUtil.showVistaPrincipal(tipoProductos, "TipoProducto", TipoProducto.class, this);
    }
    
    /**
     * Muestra la ventanta principal de cliente
     */
    public void showClientePrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<Cliente> clientes = clienteService.ListarClientes();
        VistaUtil.showVistaPrincipal(clientes, "Cliente", Cliente.class, this);
    }
    
    /**
     * Muestra la ventanta principal de trabajador
     */
    public void showTrabajadorPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<Trabajador> trabajadores = trabajadorService.ListarTrabajadores();
        VistaUtil.showVistaPrincipal(trabajadores, "Trabajador", Trabajador.class, this);
    }
    
    /**
     * Muestra la ventanta principal de color
     */
    public void showColorPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<Color> colores = colorService.ListarColores();
        VistaUtil.showVistaPrincipal(colores, "Color", Color.class, this);
    }
    
    /**
     * Muestra la ventanta principal de color
     */
    public void showActividadPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<Actividad> actividades = actividadService.ListarActividades();
        VistaUtil.showVistaPrincipal(actividades, "Actividad", Actividad.class, this);
    }
    
    /**
     * Muestra la ventanta principal de producto
     */
    public void showProductoPrincipal() {
        //TipoProductoService tps = new TipoProductoService();
        List<Producto> productos = productoService.ListarProductos();
        VistaUtil.showVistaPrincipal(productos, "Producto", Producto.class, this);
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

    public ClienteService getClienteService() {
        return clienteService;
    }

    public TrabajadorService getTrabajadorService() {
        return trabajadorService;
    }

    public ColorService getColorService() {
        return colorService;
    }

    public ActividadService getActividadService() {
        return actividadService;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public TrabajoService getTrabajoService() {
        return trabajoService;
    }
    
    
    
    
    
    
    
    
    //Main
    public static void main(String[] args) {
        launch(args);
    }

    
    
    
    
    
}
