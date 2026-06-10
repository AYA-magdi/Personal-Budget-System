package app;

import domain.repositories.BudgetRepository;
import domain.repositories.ExpenseRepository;
import domain.repositories.IncomeRepository;
import domain.repositories.ReminderRepository;
import domain.repositories.UserRepository;

import infrastructure.repositories.FileBudgetRepository;
import infrastructure.repositories.FileExpenseRepository;
import infrastructure.repositories.FileIncomeRepository;
import infrastructure.repositories.FileReminderRepository;
import infrastructure.repositories.FileUserRepository;

import services.AuthService;
import services.BudgetService;
import services.ExpenseService;
import services.IncomeService;
import services.ReminderService;
import services.UserService;

import ui.MainWindow;

import javax.swing.*;

public class BudgetApplication {

    private final UserRepository userRepository;

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;
    private final ReminderRepository reminderRepository;

    private final AuthService authService;
    private final UserService userService;

    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final BudgetService budgetService;
    private final ReminderService reminderService;

    private final MainWindow mainWindow;

    public BudgetApplication() {

        /*
         * Repositories
         */

        userRepository = new FileUserRepository();

        incomeRepository = new FileIncomeRepository();

        expenseRepository = new FileExpenseRepository();

        budgetRepository = new FileBudgetRepository();

        reminderRepository = new FileReminderRepository();

        /*
         * Services
         */

        authService = new AuthService(
                userRepository);

        userService = new UserService(
                userRepository);

        incomeService = new IncomeService(
                incomeRepository);

        expenseService = new ExpenseService(
                expenseRepository);

        budgetService = new BudgetService(
                budgetRepository);

        reminderService = new ReminderService(
                reminderRepository);

        /*
         * Main Window
         */

        mainWindow = new MainWindow();

        configureNavigation();
    }

    private void configureNavigation() {

        /*
         * Login -> Register
         */

        mainWindow
                .getLoginView()
                .getSignUpButton()
                .addActionListener(
                        e -> mainWindow.showRegisterView());

        /*
         * Register -> Login
         */

        mainWindow
                .getRegisterView()
                .getRegisterButton()
                .addActionListener(
                        e -> mainWindow.showLoginView());

        /*
         * Login Process
         */

        mainWindow
                .getLoginView()
                .getLoginButton()
                .addActionListener(
                        e -> performLogin());

        /*
         * Logout
         */

        mainWindow.configureLogout(
                () -> JOptionPane.showMessageDialog(
                        mainWindow,
                        "Logged out successfully."));
    }

    private void performLogin() {

        try {

            String email = mainWindow
                    .getLoginView()
                    .getEmailField()
                    .getText();

            String password = new String(
                    mainWindow
                            .getLoginView()
                            .getPasswordField()
                            .getPassword());

            var currentUser = authService.login(
                    email,
                    password);

            mainWindow.initializeDashboard(
                    currentUser,
                    incomeService,
                    expenseService,
                    budgetService,
                    reminderService);

            mainWindow.showDashboardView();

            JOptionPane.showMessageDialog(
                    mainWindow,
                    "Welcome " +
                            currentUser.getName());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    mainWindow,
                    ex.getMessage(),
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void start() {

        SwingUtilities.invokeLater(
                () -> mainWindow.setVisible(
                        true));
    }
}