package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

public class ListPanel extends JPanel{

    private JLabel titleLable;

    public ListPanel(){
        setLayout(null);
        setSize(400, 280);
        Font font15 = new Font("Arial", Font.BOLD, 15);

        titleLable = new JLabel("Список Вагонов");

        titleLable.setFont(font15);
        
        titleLable.setBounds(170, 5, 150, 20);

        add(titleLable);
    }
    
}
