package com.accounts.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;

public class HeadMenu extends JPanel {

    private JButton addCarriageButton;
    private JButton listCarriagesButton;

    public HeadMenu(){
        setLayout(null);

        setSize(650, 20);

        addCarriageButton = new JButton("Добавить");
        addCarriageButton.setBounds(0, 0, 110, 20);

        listCarriagesButton = new JButton("Список");
        listCarriagesButton.setBounds(110, 0, 110, 20);

        add(addCarriageButton);
        add(listCarriagesButton);

    }

    public void addCarriageButtonListener(ActionListener actionListener) {
        addCarriageButton.addActionListener(actionListener);
    }

    public void listCarriagesButtonListener(ActionListener listener) {
        listCarriagesButton.addActionListener(listener);
    }
}
