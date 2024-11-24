/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controladores.CrearCuentaController;
import core.models.Bank;
import Controladores.CrearUsuarioController;
import Controladores.ObtenerInformacionCuentasController;
import Controladores.ObtenerInformacionTransaccionesController;
import Controladores.ObtenerInformacionUsuariosController;
import Controladores.RealizarTransaccionController;

/**
 *
 * @author edangulo
 */
public class MainVista extends javax.swing.JFrame {

    private final Bank bankmodel;
    private javax.swing.JTabbedPane PanelOpciones;
    //// Vistas
    private RegistroUsuarioView registroUsuarioView;
    private CrearCuentaView crearCuentaView;
    private HacerTransaccionView hacerTransaccionView;
    private ListarCuentasView listarCuentasView;
    private ListarUsuariosView listarUsuariosView;
    private ListarTransaccionesView listarTransaccionesView;
    
    //////

    ///// Controladores
    private CrearUsuarioController crearUsuarioController;
    private CrearCuentaController crearCuentaController;
    private ObtenerInformacionCuentasController obtenerInformacionCuentasController;
    private ObtenerInformacionTransaccionesController obtenerInformacionTransaccionesController;
    private ObtenerInformacionUsuariosController obtenerInformacionUsuariosController;
    private RealizarTransaccionController realizarTransaccionController;

    //////

    public MainVista() {
        this.bankmodel = new Bank();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        PanelOpciones = new javax.swing.JTabbedPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        configurarVistas();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelOpciones)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    public void configurarVistas() {

///////                     Registrar Usuario
        registroUsuarioView = new RegistroUsuarioView();
        PanelOpciones.addTab("Register User", registroUsuarioView);
        crearUsuarioController = new CrearUsuarioController(registroUsuarioView, this.bankmodel);
///////

///////                         Crear Cuenta
        crearCuentaView = new CrearCuentaView();
        PanelOpciones.addTab("Create Account", crearCuentaView);
        crearCuentaController = new CrearCuentaController(crearCuentaView, this.bankmodel);
///////

///////                        Hacer Transaccion
        hacerTransaccionView = new HacerTransaccionView();
        PanelOpciones.addTab("Make Transaction", hacerTransaccionView);
        realizarTransaccionController = new RealizarTransaccionController(hacerTransaccionView, this.bankmodel);
///////

///////                        Listar Usuarios
        listarUsuariosView = new ListarUsuariosView();
        PanelOpciones.addTab("List Users", listarUsuariosView);
        obtenerInformacionUsuariosController = new ObtenerInformacionUsuariosController(listarUsuariosView, this.bankmodel);
///////

///////                           Listar Cuentas
        listarCuentasView = new ListarCuentasView();
        PanelOpciones.addTab("List Accounts", listarCuentasView);
        obtenerInformacionCuentasController = new ObtenerInformacionCuentasController(listarCuentasView, this.bankmodel);
        //////     

        //////////////////////// Listar transacciones
        listarTransaccionesView = new ListarTransaccionesView();
        PanelOpciones.addTab("List Transactions", listarTransaccionesView);
        obtenerInformacionTransaccionesController = new ObtenerInformacionTransaccionesController(listarTransaccionesView, this.bankmodel);
        // Configurar acción del botón refrescar

    }
}




