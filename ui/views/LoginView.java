package ui.views;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {

    private JTextField emailField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton signUpButton;
    private JButton forgotPasswordButton;

    public LoginView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        forgotPasswordButton = new JButton("Forgot Password");
    }

    private void buildLayout() {

        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Email:"));
        add(emailField);

        add(new JLabel("Password:"));
        add(passwordField);

        add(new JLabel());
        add(loginButton);

        add(new JLabel());
        add(signUpButton);

        add(new JLabel());
        add(forgotPasswordButton);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getForgotPasswordButton() {
        return forgotPasswordButton;
    }
}