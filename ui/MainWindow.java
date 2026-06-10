package ui;

import domain.models.User;

import services.AuthService;
import services.BudgetService;
import services.ExpenseService;
import services.IncomeService;
import services.ReminderService;

import ui.controllers.AuthController;
import ui.controllers.BudgetController;
import ui.controllers.ExpenseController;
import ui.controllers.IncomeController;
import ui.controllers.ReminderController;

import ui.views.BudgetView;
import ui.views.DashboardView;
import ui.views.ExpenseView;
import ui.views.IncomeView;
import ui.views.LoginView;
import ui.views.RegisterView;
import ui.views.ReminderView;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private LoginView loginView;
    private RegisterView registerView;
    private DashboardView dashboardView;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainWindow() {

        initializeFrame();
        initializeViews();
    }

    private void initializeFrame() {

        setTitle(
                "Personal Budget System");

        setSize(
                900,
                600);

        setLocationRelativeTo(
                null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();

        mainPanel = new JPanel(
                cardLayout);

        add(mainPanel);
    }

    private void initializeViews() {

        loginView = new LoginView();

        registerView = new RegisterView();

        dashboardView = new DashboardView();

        mainPanel.add(
                loginView,
                "LOGIN");

        mainPanel.add(
                registerView,
                "REGISTER");

        mainPanel.add(
                dashboardView,
                "DASHBOARD");

        cardLayout.show(
                mainPanel,
                "LOGIN");
    }

    public void showLoginView() {

        cardLayout.show(
                mainPanel,
                "LOGIN");
    }

    public void showRegisterView() {

        cardLayout.show(
                mainPanel,
                "REGISTER");
    }

    public void showDashboardView() {

        cardLayout.show(
                mainPanel,
                "DASHBOARD");
    }

    public LoginView getLoginView() {

        return loginView;
    }

    public RegisterView getRegisterView() {

        return registerView;
    }

    public DashboardView getDashboardView() {

        return dashboardView;
    }

    /**
     * Creates dashboard tabs
     * after successful login
     */
    public void initializeDashboard(
            User currentUser,
            IncomeService incomeService,
            ExpenseService expenseService,
            BudgetService budgetService,
            ReminderService reminderService) {

        dashboardView
                .getTabbedPane()
                .removeAll();

        IncomeView incomeView = new IncomeView();

        ExpenseView expenseView = new ExpenseView();

        BudgetView budgetView = new BudgetView();

        ReminderView reminderView = new ReminderView();

        new IncomeController(
                incomeService,
                incomeView,
                currentUser);

        new ExpenseController(
                expenseService,
                expenseView,
                currentUser);

        new BudgetController(
                budgetService,
                budgetView,
                currentUser);

        new ReminderController(
                reminderService,
                reminderView,
                currentUser);

        dashboardView
                .getTabbedPane()
                .addTab(
                        "Income",
                        incomeView);

        dashboardView
                .getTabbedPane()
                .addTab(
                        "Expenses",
                        expenseView);

        dashboardView
                .getTabbedPane()
                .addTab(
                        "Budget",
                        budgetView);

        dashboardView
                .getTabbedPane()
                .addTab(
                        "Reminders",
                        reminderView);
    }

    /**
     * Logout action
     */
    public void configureLogout(
            Runnable logoutAction) {

        dashboardView
                .getLogoutButton()
                .addActionListener(
                        e -> {

                            int result = JOptionPane
                                    .showConfirmDialog(
                                            this,
                                            "Logout?",
                                            "Confirm",
                                            JOptionPane.YES_NO_OPTION);

                            if (result == JOptionPane.YES_OPTION) {

                                logoutAction.run();

                                showLoginView();
                            }
                        });
    }
}