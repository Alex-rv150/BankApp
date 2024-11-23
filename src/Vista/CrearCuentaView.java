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
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userIdLabel)
                                        .addComponent(initialBalanceLabel))
                                .addGap(18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userIdInput)
                                        .addComponent(initialBalanceInput, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addContainerGap(30, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addGap(100)
                                .addComponent(tituloLabel))
                        .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addGap(150)
                                .addComponent(crearCuentaBoton))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(tituloLabel)
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(userIdLabel)
                                        .addComponent(userIdInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(initialBalanceLabel)
                                        .addComponent(initialBalanceInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30)
                                .addComponent(crearCuentaBoton)
                                .addContainerGap(30, Short.MAX_VALUE))
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
