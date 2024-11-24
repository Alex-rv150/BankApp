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

        tipoTransaccionInput = new JComboBox<>(new String[]{"Deposit", "Withdraw", "Transfer"});
        cuentaOrigenInput = new JTextField();
        cuentaDestinoInput = new JTextField();
        montoInput = new JTextField();
        ejecutarBoton = new JButton("Execute");
        ejecutarBoton.setFont(new java.awt.Font("Segoe UI", 3, 12));

        // Configuración del diseño
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tipoTransaccionLabel)
                                                        .addComponent(montoLabel)
                                                        .addComponent(cuentaDestinoLabel)
                                                        .addComponent(cuentaOrigenLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cuentaDestinoInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(cuentaOrigenInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(tipoTransaccionInput, 0, 485, Short.MAX_VALUE)
                                                        .addComponent(montoInput, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(227, 227, 227)
                                                .addComponent(tituloLabel)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(ejecutarBoton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tituloLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tipoTransaccionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tipoTransaccionLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cuentaOrigenInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cuentaOrigenLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cuentaDestinoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cuentaDestinoLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(montoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(montoLabel))
                                .addGap(18, 18, 18)
                                .addComponent(ejecutarBoton)
                                .addContainerGap(83, Short.MAX_VALUE))
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
