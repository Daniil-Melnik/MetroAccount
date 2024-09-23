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

        String[] columnNames = { "Номер", "Тип", "Завод", "Год выпуска", "Линия", "Дата", "Время" };

        String[][] data;

        try {
            data = jsonParser.getAllVagonsString();
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 25, 718, 250);
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
