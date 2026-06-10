package ui.views;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {

    private JTabbedPane tabbedPane;
    private JButton logoutButton;

    public DashboardView() {

        setLayout(new BorderLayout());

        logoutButton = new JButton("Logout");

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(
                logoutButton,
                BorderLayout.EAST);

        tabbedPane = new JTabbedPane();

        add(topPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}