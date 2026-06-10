package ui.views;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JPanel {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private JButton registerButton;

    public RegisterView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        registerButton = new JButton("Create Account");
    }

    private void buildLayout() {

        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Name"));
        add(nameField);

        add(new JLabel("Email"));
        add(emailField);

        add(new JLabel("Phone"));
        add(phoneField);

        add(new JLabel("Password"));
        add(passwordField);

        add(new JLabel("Confirm Password"));
        add(confirmPasswordField);

        add(new JLabel());
        add(registerButton);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}