/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 *
 * @author arang
 */


public class ListarUsuariosView extends JPanel {
    // Componentes de la vista
    private JLabel tituloLabel;
    private JTable usuariosTabla;
    private JScrollPane tablaScrollPane;
    private JButton refrescarBoton;
    private DefaultTableModel tableModel;

    public ListarUsuariosView() {
        initComponents();
    }

    private void initComponents() {
        tituloLabel = new JLabel("List Users");
        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));

        // Configuración de la tabla
        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Fullname", "Age", "Number of Accounts"}
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Long.class;
                    case 1 -> String.class;
                    case 2 -> Integer.class;
                    case 3 -> Integer.class;
                    default -> Object.class;
                }; // ID
                // Fullname
                // Age
                // Number of Accounts
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // No se puede editar
            }
        };

        usuariosTabla = new JTable(tableModel);
        tablaScrollPane = new JScrollPane(usuariosTabla);

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
