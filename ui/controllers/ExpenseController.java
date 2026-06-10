package ui.controllers;

import domain.models.Expense;
import domain.models.User;
import services.ExpenseService;
import ui.views.ExpenseView;
import validators.ExpenseValidator;

import javax.swing.*;

public class ExpenseController {

    private final ExpenseService service;
    private final ExpenseView view;
    private final User currentUser;

    public ExpenseController(
            ExpenseService service,
            ExpenseView view,
            User currentUser) {

        this.service = service;
        this.view = view;
        this.currentUser = currentUser;

        initializeEvents();
    }

    private void initializeEvents() {

        view.getAddButton()
                .addActionListener(
                        e -> addExpense());
    }

    private void addExpense() {

        try {

            Expense expense = new Expense(
                    view.getCategoryField()
                            .getText(),

                    Double.parseDouble(
                            view.getAmountField()
                                    .getText()),

                    view.getDateField()
                            .getText(),

                    view.getMethodField()
                            .getText());

            ExpenseValidator.validate(
                    expense);

            service.addExpense(
                    currentUser,
                    expense);

            view.getListModel()
                    .addElement(
                            expense.getCategory()
                                    + " - "
                                    + expense.getAmount());

            JOptionPane.showMessageDialog(
                    view,
                    "Expense Added");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage());
        }
    }
}