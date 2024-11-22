/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vista;
/**
 *
 * @author arang
 */

import javax.swing.*;
import java.awt.event.ActionListener;

public class HacerTransaccionView extends JPanel {
    // Componentes de la vista
    private JLabel tituloLabel;
    private JLabel tipoTransaccionLabel;
    private JLabel cuentaOrigenLabel;
    private JLabel cuentaDestinoLabel;
    private JLabel montoLabel;
    private JComboBox<String> tipoTransaccionInput;
    private JTextField cuentaOrigenInput;
    private JTextField cuentaDestinoInput;
    private JTextField montoInput;
    private JButton ejecutarBoton;

    public HacerTransaccionView() {
        initComponents();
    }

    private void initComponents() {
        tituloLabel = new JLabel("Make Transaction");
        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));

        tipoTransaccionLabel = new JLabel("Type");
        tipoTransaccionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        cuentaOrigenLabel = new JLabel("Source Account");
        cuentaOrigenLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        cuentaDestinoLabel = new JLabel("Destination Account");
        cuentaDestinoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        montoLabel = new JLabel("Amount");
        montoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));

        tipoTransaccionInput = new JComboBox<>(new String[] { "Deposit", "Withdraw", "Transfer" });
        cuentaOrigenInput = new JTextField();
        cuentaDestinoInput = new JTextField();
        montoInput = new JTextField();
        ejecutarBoton = new JButton("Execute");
        ejecutarBoton.setFont(new java.awt.Font("Segoe UI", 3, 12));

        // Configuración del diseño
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tipoTransaccionLabel)
                        .addComponent(cuentaOrigenLabel)
                        .addComponent(cuentaDestinoLabel)
                        .addComponent(montoLabel))
                    .addGap(18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(tipoTransaccionInput, 0, 200, Short.MAX_VALUE)
                        .addComponent(cuentaOrigenInput)
                        .addComponent(cuentaDestinoInput)
                        .addComponent(montoInput))
                    .addContainerGap(30, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                    .addGap(100)
                    .addComponent(tituloLabel))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                    .addGap(150)
                    .addComponent(ejecutarBoton))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(tituloLabel)
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tipoTransaccionLabel)
                        .addComponent(tipoTransaccionInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cuentaOrigenLabel)
                        .addComponent(cuentaOrigenInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cuentaDestinoLabel)
                        .addComponent(cuentaDestinoInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(montoLabel)
                        .addComponent(montoInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addComponent(ejecutarBoton)
                    .addContainerGap(30, Short.MAX_VALUE))
        );
    }

    // Métodos para interactuar con la vista
    public String getTipoTransaccion() {
        return (String) tipoTransaccionInput.getSelectedItem();
    }

    public String getCuentaOrigen() {
        return cuentaOrigenInput.getText();
    }

    public String getCuentaDestino() {
        return cuentaDestinoInput.getText();
    }

    public String getMonto() {
        return montoInput.getText();
    }

    public void clearFields() {
        cuentaOrigenInput.setText("");
        cuentaDestinoInput.setText("");
        montoInput.setText("");
    }

    public void setEjecutarAction(ActionListener actionListener) {
        ejecutarBoton.addActionListener(actionListener);
    }
}
