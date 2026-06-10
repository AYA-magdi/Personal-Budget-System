package ui.controllers;

import domain.models.Budget;
import domain.models.User;
import services.BudgetService;
import ui.views.BudgetView;
import validators.BudgetValidator;

import javax.swing.*;

public class BudgetController {

    private final BudgetService service;
    private final BudgetView view;
    private final User currentUser;

    public BudgetController(
            BudgetService service,
            BudgetView view,
            User currentUser) {

        this.service = service;
        this.view = view;
        this.currentUser = currentUser;

        initializeEvents();
    }

    private void initializeEvents() {

        view.getSaveButton()
                .addActionListener(
                        e -> saveBudget());

        view.getAnalyzeButton()
                .addActionListener(
                        e -> analyzeBudget());
    }

    private void saveBudget() {

        try {

            Budget budget = new Budget(
                    view.getCategoryField()
                            .getText(),

                    Double.parseDouble(
                            view.getAmountField()
                                    .getText()));

            BudgetValidator.validate(
                    budget);

            service.addBudget(
                    currentUser,
                    budget);

            JOptionPane.showMessageDialog(
                    view,
                    "Budget Saved");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage());
        }
    }

    private void analyzeBudget() {

        String report = service.analyzeBudget(
                currentUser);

        view.getAnalysisArea()
                .setText(report);
    }
}