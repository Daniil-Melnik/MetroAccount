package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListPanel extends JPanel{

    private JLabel titleLable;

    public ListPanel(){
        setLayout(null);
        setSize(400, 280);

        titleLable = new JLabel("Список Вагонов");
        
        titleLable.setBounds(150, 0, 100, 20);

        add(titleLable);
    }
    
}
