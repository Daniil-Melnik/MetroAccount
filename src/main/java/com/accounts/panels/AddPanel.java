package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddPanel extends JPanel {

    private JLabel titleLable;

    public AddPanel() {
        setLayout(null);
        setSize(400, 280);

        titleLable = new JLabel("Добавить вагон");

        titleLable.setBounds(150, 0, 100, 20);

        add(titleLable);
    }
}
