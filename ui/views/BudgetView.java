package ui.views;

import javax.swing.*;
import java.awt.*;

public class BudgetView extends JPanel {

    private JTextField categoryField;
    private JTextField amountField;

    private JButton saveButton;
    private JButton analyzeButton;

    private JTextArea analysisArea;

    public BudgetView() {

        initializeComponents();
        buildLayout();
    }

    private void initializeComponents() {

        categoryField = new JTextField();
        amountField = new JTextField();

        saveButton = new JButton("Save Budget");
        analyzeButton = new JButton("Analyze");

        analysisArea = new JTextArea();
        analysisArea.setEditable(false);
    }

    private void buildLayout() {

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(
                new GridLayout(3, 2));

        panel.add(new JLabel("Category"));
        panel.add(categoryField);

        panel.add(new JLabel("Amount"));
        panel.add(amountField);

        panel.add(saveButton);
        panel.add(analyzeButton);

        add(panel, BorderLayout.NORTH);

        add(
                new JScrollPane(
                        analysisArea),
                BorderLayout.CENTER);
    }

    public JTextField getCategoryField() {
        return categoryField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getAnalyzeButton() {
        return analyzeButton;
    }

    public JTextArea getAnalysisArea() {
        return analysisArea;
    }
}