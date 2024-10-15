package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class FilterPanel extends JPanel {

    private JLabel titleLable;

    public FilterPanel() {
        setLayout(null);
        setSize(730, 320);

        Font font15 = new Font("Arial", Font.BOLD, 15);

        titleLable = new JLabel("Фильтр поездок");
        titleLable.setFont(font15);

        titleLable.setBounds(170, 5, 150, 20);

        add(titleLable);
    }
}
