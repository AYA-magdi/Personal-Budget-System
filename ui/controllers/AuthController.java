package ui.controllers;

import domain.models.User;
import services.AuthService;
import ui.views.LoginView;
import ui.views.RegisterView;

import javax.swing.*;

public class AuthController {

    private final AuthService authService;

    private final LoginView loginView;
    private final RegisterView registerView;

    private User loggedInUser;

    public AuthController(
            AuthService authService,
            LoginView loginView,
            RegisterView registerView) {

        this.authService = authService;
        this.loginView = loginView;
        this.registerView = registerView;

        initializeLoginActions();
        initializeRegisterActions();
    }

    private void initializeLoginActions() {

        loginView
                .getLoginButton()
                .addActionListener(e -> login());
    }

    private void initializeRegisterActions() {

        registerView
                .getRegisterButton()
                .addActionListener(
                        e -> register());
    }

    private void login() {

        try {

            String email = loginView
                    .getEmailField()
                    .getText();

            String password = new String(
                    loginView
                            .getPasswordField()
                            .getPassword());

            loggedInUser = authService.login(
                    email,
                    password);

            JOptionPane.showMessageDialog(
                    loginView,
                    "Login Successful");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    loginView,
                    ex.getMessage());
        }
    }

    private void register() {

        try {

            String name = registerView
                    .getNameField()
                    .getText();

            String email = registerView
                    .getEmailField()
                    .getText();

            String phone = registerView
                    .getPhoneField()
                    .getText();

            String password = new String(
                    registerView
                            .getPasswordField()
                            .getPassword());

            String confirmPassword = new String(
                    registerView
                            .getConfirmPasswordField()
                            .getPassword());

            if (!password.equals(
                    confirmPassword)) {

                throw new IllegalArgumentException(
                        "Passwords do not match.");
            }

            authService.register(
                    name,
                    email,
                    phone,
                    password);

            JOptionPane.showMessageDialog(
                    registerView,
                    "Registration Successful");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    registerView,
                    ex.getMessage());
        }
    }

    public User getLoggedInUser() {

        return loggedInUser;
    }
}