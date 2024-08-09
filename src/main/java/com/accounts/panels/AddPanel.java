package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddPanel extends JPanel {

    private JLabel TitleLable;

    public AddPanel(){
        setLayout(null);
        setSize(400, 250);

        TitleLable = new JLabel("Добавить вагон");
        TitleLable.setBounds(150, 0, 400, 50);
        add(TitleLable);
    }
}
