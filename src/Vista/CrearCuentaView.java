/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author arang
 */
public class CrearCuentaView extends JPanel {

    // Componentes de la vista
    private JLabel tituloLabel;
    private JLabel userIdLabel;
    private JLabel initialBalanceLabel;
    private JTextField userIdInput;
    private JTextField initialBalanceInput;
    private JButton crearCuentaBoton;

    public CrearCuentaView() {
        initComponents();
    }

    private void initComponents() {
        tituloLabel = new JLabel("Create Account");
        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));

        userIdLabel = new JLabel("User ID");
        userIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        initialBalanceLabel = new JLabel("Initial Balance");
        initialBalanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        userIdInput = new JTextField();
        initialBalanceInput = new JTextField();

        crearCuentaBoton = new JButton("Create");
        crearCuentaBoton.setFont(new java.awt.Font("Segoe UI", 3, 12));

      

    
        
        // Configuración del diseño
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(tituloLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdLabel)
                            .addComponent(initialBalanceLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initialBalanceInput)
                            .addComponent(userIdInput, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(crearCuentaBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tituloLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialBalanceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialBalanceLabel))
                .addGap(18, 18, 18)
                .addComponent(crearCuentaBoton)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        
        
    }
    
                               


    // Métodos para interactuar con la vista
    public String getUserIdInput() {
        return userIdInput.getText();
    }

    public String getInitialBalanceInput() {
        return initialBalanceInput.getText();
    }

    public void clearFields() {
        userIdInput.setText("");
        initialBalanceInput.setText("");
    }

    public void setCrearCuentaAction(ActionListener actionListener) {
        crearCuentaBoton.addActionListener(actionListener);
    }
}
