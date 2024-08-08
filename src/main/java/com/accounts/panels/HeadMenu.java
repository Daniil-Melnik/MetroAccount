package com.accounts.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HeadMenu extends JPanel {

    private JButton addCarriageButton;
    private JButton listCarriagesButton;

    public HeadMenu(){
        setLayout(null);

        setSize(400, 100);

        addCarriageButton = new JButton("Добавить");
        addCarriageButton.setBounds(0, 0, 110, 25);

        listCarriagesButton = new JButton("Список");
        listCarriagesButton.setBounds(115, 0, 110, 25);

        add(addCarriageButton);
        add(listCarriagesButton);

    }
}
