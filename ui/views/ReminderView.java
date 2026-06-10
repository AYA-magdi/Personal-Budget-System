package ui.views;

import javax.swing.*;
import java.awt.*;

public class ReminderView extends JPanel {

    private JTextField titleField;
    private JTextField dateField;
    private JTextField timeField;

    private JButton addButton;

    private DefaultListModel<String> listModel;
    private JList<String> reminderList;

    public ReminderView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        titleField = new JTextField();
        dateField = new JTextField();
        timeField = new JTextField();

        addButton = new JButton("Add Reminder");

        listModel = new DefaultListModel<>();
        reminderList = new JList<>(listModel);
    }

    private void buildLayout() {

        setLayout(new BorderLayout());

        add(
                new JScrollPane(
                        reminderList),
                BorderLayout.CENTER);

        JPanel panel = new JPanel(
                new GridLayout(4, 2));

        panel.add(new JLabel("Title"));
        panel.add(titleField);

        panel.add(new JLabel("Date"));
        panel.add(dateField);

        panel.add(new JLabel("Time"));
        panel.add(timeField);

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}