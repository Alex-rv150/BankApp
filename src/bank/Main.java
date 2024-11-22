/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bank;

import User.User;
import Transaction.TransactionType;
import Transaction.Transaction;
import Account.Account;
import Vista.CrearCuentaView;
import Vista.HacerTransaccionView;
import Vista.ListarCuentasView;
import Vista.ListarTransaccionesView;
import Vista.ListarUsuariosView;
import Vista.RegistroUsuarioView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author edangulo
 */
public class Main extends javax.swing.JFrame {
    private final ArrayList<Account> accounts;
    private final ArrayList<Transaction> transactions;
    private final ArrayList<User> users;
    
    
    
    //// Vistas
    private RegistroUsuarioView registroUsuarioView;
    private CrearCuentaView crearCuentaView;
    private HacerTransaccionView  hacerTransaccionView;
    private ListarCuentasView  listarCuentasView;
    private ListarUsuariosView  listarUsuariosView;
    private ListarTransaccionesView  listarTransaccionesView;

    //////
    
    
    /**
     * Creates new form BankFrame
     */
    public Main() {
        initComponents();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {                         
        PanelOpciones = new javax.swing.JTabbedPane();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        
        

//////////////////////////////////////////////////////Registrar Usuario
        registroUsuarioView = new RegistroUsuarioView();
        PanelOpciones.addTab("Register User", registroUsuarioView);

        // Configurar acción del botón en RegistroUsuarioView
        registroUsuarioView.setRegistroUsuarioBotonActionListener(evt -> {
            try {
                int id = Integer.parseInt(registroUsuarioView.getIdInput());
                String firstname = registroUsuarioView.getFirstnameInput();
                String lastname = registroUsuarioView.getLastnameInput();
                int age = Integer.parseInt(registroUsuarioView.getAgeInput());

                // Agregar usuario
                users.add(new User(id, firstname, lastname, age));
                registroUsuarioView.clearFields();
                JOptionPane.showMessageDialog(this, "User registered successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error registering user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
//////////////////////////////////////////////


//////////////////////////////////////////////////////// Crear Cuenta
        crearCuentaView = new CrearCuentaView();
        PanelOpciones.addTab("Create Account", crearCuentaView);
        
          crearCuentaView.setCrearCuentaAction(evt -> {
            try {
                int userId = Integer.parseInt(crearCuentaView.getUserIdInput());
                double initialBalance = Double.parseDouble(crearCuentaView.getInitialBalanceInput());

                User selectedUser = null;
                for (User user : users) {
                    if (user.getId() == userId) {
                        selectedUser = user;
                        break;
                    }
                }

                if (selectedUser != null) {
                    Random random = new Random();
                    String accountId = String.format("%03d-%06d-%02d",
                        random.nextInt(1000), random.nextInt(1000000), random.nextInt(100));

                    accounts.add(new Account(accountId, selectedUser, initialBalance));
                    crearCuentaView.clearFields();
                    JOptionPane.showMessageDialog(this, "Account created successfully!");
                } else {
                    throw new Exception("User not found");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error creating account: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
/////////////////////////////////////////////////







          
          
///////////////////////////////////////////  Hacer Transaccion

        hacerTransaccionView = new HacerTransaccionView();
        PanelOpciones.addTab("Make Transaction", hacerTransaccionView);
         hacerTransaccionView.setEjecutarAction(evt -> {
            try {
                String tipo = hacerTransaccionView.getTipoTransaccion();
                String cuentaOrigen = hacerTransaccionView.getCuentaOrigen();
                String cuentaDestino = hacerTransaccionView.getCuentaDestino();
                double monto = Double.parseDouble(hacerTransaccionView.getMonto());

                Account origen = null, destino = null;
                for (Account account : accounts) {
                    if (account.getId().equals(cuentaOrigen)) origen = account;
                    if (account.getId().equals(cuentaDestino)) destino = account;
                }

                switch (tipo) {
                    case "Deposit" -> {
                        if (destino != null) {
                            destino.deposit(monto);
                            transactions.add(new Transaction(TransactionType.DEPOSIT, null, destino, monto));
                        }
                    }
                    case "Withdraw" -> {
                        if (origen != null && origen.withdraw(monto)) {
                            transactions.add(new Transaction(TransactionType.WITHDRAW, origen, null, monto));
                        }
                    }
                    case "Transfer" -> {
                        if (origen != null && destino != null && origen.withdraw(monto)) {
                            destino.deposit(monto);
                            transactions.add(new Transaction(TransactionType.TRANSFER, origen, destino, monto));
                        }
                    }
                }
                hacerTransaccionView.clearFields();
                JOptionPane.showMessageDialog(this, "Transaction executed successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error executing transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
         
         
 /////////////////////////////////////////////
 
 
 
 
 
 
        
        
 ///////////////////////////////// Listar Usuarios

       listarUsuariosView = new ListarUsuariosView();
        PanelOpciones.addTab("List Users", listarUsuariosView);

        // Configurar acción del botón refrescar
        listarUsuariosView.setRefrescarAction(evt -> {
            listarUsuariosView.clearTable();
            for (User user : users) {
                listarUsuariosView.addRow(new Object[]{
                    user.getId(),
                    user.getFirstname() + " " + user.getLastname(),
                    user.getAge(),
                    user.getNumAccounts()
                });
            }
        });
 
  ////////////////////////////////////////
  
  
  
  
  
  ///////////////////////////////////////////Listar Cuentas

     
        listarCuentasView = new ListarCuentasView();
        PanelOpciones.addTab("List Accounts", listarCuentasView);

        // Configurar acción del botón refrescar
        listarCuentasView.setRefrescarAction(evt -> {
            listarCuentasView.clearTable();
            for (Account account : accounts) {
                listarCuentasView.addRow(new Object[]{
                    account.getId(),
                    account.getOwner().getId(),
                    account.getBalance()
                });
            }
        });


  ////////////////////
  
  
  
  
  
  //////////////////////// Listar transacciones

        
       

      listarTransaccionesView = new ListarTransaccionesView();
        PanelOpciones.addTab("List Transactions", listarTransaccionesView);

        // Configurar acción del botón refrescar
        listarTransaccionesView.setRefrescarAction(evt -> {
            listarTransaccionesView.clearTable();
            for (Transaction transaction : transactions) {
                listarTransaccionesView.addRow(new Object[]{
                    transaction.getType().name(),
                    transaction.getSourceAccount() != null ? transaction.getSourceAccount().getId() : "None",
                    transaction.getDestinationAccount() != null ? transaction.getDestinationAccount().getId() : "None",
                    transaction.getAmount()
                });
            }
        });
        
        
////////////////////////////////////



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
    
    
    
    
    
    
    
    

                                                                  

    
                                                          

                                                                

                                                              

                                                   

                                                     

                                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankFrame().setVisible(true);
            }
        });
    }

   
    private javax.swing.JTabbedPane PanelOpciones;
   
 
    
    // End of variables declaration                   
}
