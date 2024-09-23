package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class ListPanel extends JPanel{

    private JLabel titleLable;

    public ListPanel(){
        setLayout(null);
        setSize(730, 280);

        String[] columnNames = { "1", "2", "3", "4", "5", "7", "8" };

        String [][] data = {{"2024-09-01","10222","VAGONMASH","LINE_2","13:19","NOMERNOY2_1_H","1997"},{"2024-09-05","10222","VAGONMASH","LINE_2","19:24","NOMERNOY2_1_H","1997"}};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);


        Font font15 = new Font("Arial", Font.BOLD, 15);

        titleLable = new JLabel("Список Вагонов");

        titleLable.setFont(font15);
        
        scrollPane.setBounds(0, 25, 718, 250);
        titleLable.setBounds(170, 5, 150, 20);

        add(scrollPane); 
        add(titleLable);
    }
    
}
