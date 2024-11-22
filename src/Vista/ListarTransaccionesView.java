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
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class ListarTransaccionesView extends JPanel {
    // Componentes de la vista
    private JLabel tituloLabel;
    private JTable transaccionesTabla;
    private JScrollPane tablaScrollPane;
    private JButton refrescarBoton;
    private DefaultTableModel tableModel;

    public ListarTransaccionesView() {
        initComponents();
    }

    private void initComponents() {
        tituloLabel = new JLabel("List Transactions");
        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));

        // Configuración de la tabla
        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Type", "Source Account ID", "Destination Account ID", "Amount"}
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> String.class;
                    case 1, 2 -> String.class;
                    case 3 -> Double.class;
                    default -> Object.class;
                }; // Type
                // Account IDs
                // Amount
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // No se puede editar
            }
        };

        transaccionesTabla = new JTable(tableModel);
        tablaScrollPane = new JScrollPane(transaccionesTabla);

        refrescarBoton = new JButton("Refresh");
        refrescarBoton.setFont(new java.awt.Font("Segoe UI", 3, 12));

        // Configuración del diseño
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tituloLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refrescarBoton))
                        .addComponent(tablaScrollPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addGap(20))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tituloLabel)
                        .addComponent(refrescarBoton))
                    .addGap(20)
                    .addComponent(tablaScrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGap(20))
        );
    }

    // Métodos para interactuar con la vista
    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }

    public void clearTable() {
        tableModel.setRowCount(0);
    }

    public void setRefrescarAction(ActionListener actionListener) {
        refrescarBoton.addActionListener(actionListener);
    }
}
