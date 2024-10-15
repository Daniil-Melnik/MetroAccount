package com.accounts.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.json.simple.parser.ParseException;

import com.accounts.JsonAPI.JsonIO;
import com.accounts.JsonAPI.JsonParser;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ListPanel extends JPanel {

    private JLabel titleLable;
    private JComboBox<String> fileNameCombo;
    private String[][] data;
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames = { "Номер", "Тип", "Завод", "Год вып.", "Линия", "Дата", "Время" };
    DefaultTableModel model;

    public ListPanel() {
        setLayout(null);
        setSize(730, 280);

        String[] comboData = makeComboFileNames();
        titleLable = new JLabel("Список поездок");
        fileNameCombo = new JComboBox<>(comboData);

        fileNameCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fileNameComboListener();
            }
        });

        try {
            data = getVagonsForTable();
            model = new DefaultTableModel(data, columnNames);
            table = new JTable(model);
            setColumnWidths();
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 25, 718, 230);
            add(scrollPane);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
            // добавить : Упс... Не получилось найти базу
        }

        Font font15 = new Font("Arial", Font.BOLD, 15);

        titleLable.setFont(font15);

        titleLable.setBounds(170, 5, 150, 20);
        fileNameCombo.setBounds(330, 5, 60, 20);

        add(titleLable);
        add(fileNameCombo);
    }

    private String[] makeComboFileNames() {
        JsonIO jsonIO = new JsonIO();

        String[] fileNumberNames = jsonIO.getHeadFileNumbersString();
        String[] addAll = { "..." };

        String[] comboData = new String[1 + fileNumberNames.length];

        System.arraycopy(addAll, 0, comboData, 0, addAll.length);
        System.arraycopy(fileNumberNames, 0, comboData, addAll.length, fileNumberNames.length);

        return comboData;
    }

    private String[][] getVagonsForTable() throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        String[][] dataM;
        String comboValue = fileNameCombo.getSelectedItem().toString();
        System.out.println(comboValue);
        if (comboValue.equals("...")) {
            dataM = jsonParser.getAllVagonsString();
        } else {
            dataM = jsonParser.getVagonsOfFileString(comboValue);
        }
        return dataM;
    }

    private void setColumnWidths() {
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        table.getColumnModel().getColumn(6).setPreferredWidth(15);
    }

    private void fileNameComboListener() {
        try {
            data = getVagonsForTable();
            model.setDataVector(data, columnNames);
            setColumnWidths();
            scrollPane.repaint();
            scrollPane.revalidate();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
