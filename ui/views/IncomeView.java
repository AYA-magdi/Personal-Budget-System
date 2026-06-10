package ui.views;

import javax.swing.*;
import java.awt.*;

public class IncomeView extends JPanel {

    private JTextField sourceField;
    private JTextField amountField;

    private JButton addButton;

    private DefaultListModel<String> listModel;
    private JList<String> incomeList;

    public IncomeView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        sourceField = new JTextField();
        amountField = new JTextField();

        addButton = new JButton("Add Income");

        listModel = new DefaultListModel<>();
        incomeList = new JList<>(listModel);
    }

    private void buildLayout() {

        setLayout(new BorderLayout());

        add(
                new JScrollPane(incomeList),
                BorderLayout.CENTER);

        JPanel panel = new JPanel(
                new GridLayout(3, 2));

        panel.add(new JLabel("Source"));
        panel.add(sourceField);

        panel.add(new JLabel("Amount"));
        panel.add(amountField);

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);
    }

    public JTextField getSourceField() {
        return sourceField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}