package ui.controllers;

import domain.models.Income;
import domain.models.User;
import services.IncomeService;
import ui.views.IncomeView;
import validators.IncomeValidator;

import javax.swing.*;

public class IncomeController {

    private final IncomeService service;
    private final IncomeView view;
    private final User currentUser;

    public IncomeController(
            IncomeService service,
            IncomeView view,
            User currentUser) {

        this.service = service;
        this.view = view;
        this.currentUser = currentUser;

        initializeEvents();
    }

    private void initializeEvents() {

        view.getAddButton()
                .addActionListener(
                        e -> addIncome());
    }

    private void addIncome() {

        try {

            Income income = new Income(
                    view.getSourceField()
                            .getText(),

                    Double.parseDouble(
                            view.getAmountField()
                                    .getText()));

            IncomeValidator.validate(
                    income);

            service.addIncome(
                    currentUser,
                    income);

            view.getListModel()
                    .addElement(
                            income.getSource()
                                    + " - "
                                    + income.getAmount());

            JOptionPane.showMessageDialog(
                    view,
                    "Income Added");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage());
        }
    }
}