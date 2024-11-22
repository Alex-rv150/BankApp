package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegistroUsuarioView extends JPanel {

    private JLabel RegistroUsuarioTituloLabel;
    private JLabel RegistroUsuarioIdLabel;
    private JLabel RegistroUsuarioFirstnameLabel;
    private JLabel RegistroUsuarioLastnameLabel;
    private JLabel RegistroUsuarioAgeLabel;
    private JTextField RegistroUsuarioIdInput;
    private JTextField RegistroUsuarioFirstnameInput;
    private JTextField RegistroUsuarioLastnameInput;
    private JTextField RegistroUsuarioAgeInput;
    private JButton RegistroUsuarioBoton;

    public RegistroUsuarioView() {
        initComponents();
    }

    private void initComponents() {
        RegistroUsuarioTituloLabel = new JLabel();
        RegistroUsuarioIdLabel = new JLabel();
        RegistroUsuarioFirstnameLabel = new JLabel();
        RegistroUsuarioLastnameLabel = new JLabel();
        RegistroUsuarioAgeLabel = new JLabel();
        RegistroUsuarioIdInput = new JTextField();
        RegistroUsuarioFirstnameInput = new JTextField();
        RegistroUsuarioLastnameInput = new JTextField();
        RegistroUsuarioAgeInput = new JTextField();
        RegistroUsuarioBoton = new JButton();

        RegistroUsuarioTituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RegistroUsuarioTituloLabel.setText("Register User");

        RegistroUsuarioIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegistroUsuarioIdLabel.setText("ID");

        RegistroUsuarioFirstnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegistroUsuarioFirstnameLabel.setText("Firstname");

        RegistroUsuarioLastnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegistroUsuarioLastnameLabel.setText("Lastname");

        RegistroUsuarioAgeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegistroUsuarioAgeLabel.setText("Age");

        RegistroUsuarioBoton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        RegistroUsuarioBoton.setText("Register");

        // Layout setup
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(RegistroUsuarioIdLabel)
                                .addComponent(RegistroUsuarioFirstnameLabel)
                                .addComponent(RegistroUsuarioLastnameLabel)
                                .addComponent(RegistroUsuarioAgeLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(RegistroUsuarioIdInput)
                                .addComponent(RegistroUsuarioFirstnameInput)
                                .addComponent(RegistroUsuarioLastnameInput)
                                .addComponent(RegistroUsuarioAgeInput)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 240, Short.MAX_VALUE)
                            .addComponent(RegistroUsuarioTituloLabel)
                            .addGap(0, 240, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 280, Short.MAX_VALUE)
                            .addComponent(RegistroUsuarioBoton)
                            .addGap(0, 280, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(RegistroUsuarioTituloLabel)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RegistroUsuarioIdLabel)
                        .addComponent(RegistroUsuarioIdInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RegistroUsuarioFirstnameLabel)
                        .addComponent(RegistroUsuarioFirstnameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RegistroUsuarioLastnameLabel)
                        .addComponent(RegistroUsuarioLastnameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RegistroUsuarioAgeLabel)
                        .addComponent(RegistroUsuarioAgeInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(RegistroUsuarioBoton)
                    .addContainerGap(83, Short.MAX_VALUE))
        );
    }

    // Getters for components if needed
    public JTextField getRegistroUsuarioIdInput() {
        return RegistroUsuarioIdInput;
    }

    public JTextField getRegistroUsuarioFirstnameInput() {
        return RegistroUsuarioFirstnameInput;
    }

    public JTextField getRegistroUsuarioLastnameInput() {
        return RegistroUsuarioLastnameInput;
    }

    public JTextField getRegistroUsuarioAgeInput() {
        return RegistroUsuarioAgeInput;
    }

    public JButton getRegistroUsuarioBoton() {
        return RegistroUsuarioBoton;
    }
    
      // Métodos para interactuar con la vista
    public String getIdInput() {
        return RegistroUsuarioIdInput.getText();
    }

    public String getFirstnameInput() {
        return RegistroUsuarioFirstnameInput.getText();
    }

    public String getLastnameInput() {
        return RegistroUsuarioLastnameInput.getText();
    }

    public String getAgeInput() {
        return RegistroUsuarioAgeInput.getText();
    }

    public void clearFields() {
        RegistroUsuarioIdInput.setText("");
        RegistroUsuarioFirstnameInput.setText("");
        RegistroUsuarioLastnameInput.setText("");
        RegistroUsuarioAgeInput.setText("");
    }



    // Setter for button action
    public void setRegistroUsuarioBotonActionListener(ActionListener listener) {
        RegistroUsuarioBoton.addActionListener(listener);
    }
}

