package ui.controllers;

import domain.models.Reminder;
import domain.models.User;
import services.ReminderService;
import ui.views.ReminderView;
import validators.ReminderValidator;

import javax.swing.*;

public class ReminderController {

    private final ReminderService service;
    private final ReminderView view;
    private final User currentUser;

    public ReminderController(
            ReminderService service,
            ReminderView view,
            User currentUser) {

        this.service = service;
        this.view = view;
        this.currentUser = currentUser;

        initializeEvents();
    }

    private void initializeEvents() {

        view.getAddButton()
                .addActionListener(
                        e -> addReminder());
    }

    private void addReminder() {

        try {

            Reminder reminder = new Reminder(
                    view.getTitleField()
                            .getText(),

                    view.getDateField()
                            .getText(),

                    view.getTimeField()
                            .getText());

            ReminderValidator.validate(
                    reminder);

            service.addReminder(
                    currentUser,
                    reminder);

            view.getListModel()
                    .addElement(
                            reminder.getTitle()
                                    + " | "
                                    + reminder.getDate()
                                    + " | "
                                    + reminder.getTime());

            JOptionPane.showMessageDialog(
                    view,
                    "Reminder Added");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage());
        }
    }
}