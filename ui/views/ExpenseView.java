package ui.views;

import javax.swing.*;
import java.awt.*;

public class ExpenseView extends JPanel {

    private JTextField categoryField;
    private JTextField amountField;
    private JTextField dateField;
    private JTextField methodField;

    private JButton addButton;

    private DefaultListModel<String> listModel;
    private JList<String> expenseList;

    public ExpenseView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        categoryField = new JTextField();
        amountField = new JTextField();
        dateField = new JTextField();
        methodField = new JTextField();

        addButton = new JButton("Add Expense");

        listModel = new DefaultListModel<>();
        expenseList = new JList<>(listModel);
    }

    private void buildLayout() {

        setLayout(new BorderLayout());

        add(
                new JScrollPane(expenseList),
                BorderLayout.CENTER);

        JPanel panel = new JPanel(
                new GridLayout(5, 2));

        panel.add(new JLabel("Category"));
        panel.add(categoryField);

        panel.add(new JLabel("Amount"));
        panel.add(amountField);

        panel.add(new JLabel("Date"));
        panel.add(dateField);

        panel.add(new JLabel("Payment Method"));
        panel.add(methodField);

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);
    }

    public JTextField getCategoryField() {
        return categoryField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getMethodField() {
        return methodField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}