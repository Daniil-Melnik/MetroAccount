package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.json.simple.parser.ParseException;

import com.accounts.JsonAPI.JsonParser;

import java.awt.Font;
import java.io.IOException;

public class ListPanel extends JPanel{

    private JLabel titleLable;

    public ListPanel(){
        setLayout(null);
        setSize(730, 280);

        JsonParser jsonParser = new JsonParser();

        String[] columnNames = { "Номер", "Тип", "Завод", "Год вып.", "Линия", "Дата", "Время" };

        String[][] data;

        try {
            data = jsonParser.getAllVagonsString();
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(150);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
            table.getColumnModel().getColumn(6).setPreferredWidth(15);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 25, 718, 230);
            add(scrollPane);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
            // добавить : Упс... Не получилось найти базу
        }

        Font font15 = new Font("Arial", Font.BOLD, 15);

        titleLable = new JLabel("Список Вагонов");

        titleLable.setFont(font15);
        
        titleLable.setBounds(170, 5, 150, 20);

        add(titleLable);
    }
    
}
