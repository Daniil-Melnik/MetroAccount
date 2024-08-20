package com.accounts.panels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;

public class AddPanel extends JPanel {

    private JLabel titleLable;
    private JXDatePicker datePicker;

    public AddPanel() {
        setLayout(null);
        setSize(400, 280);

        datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        titleLable = new JLabel("Добавить вагон");

        titleLable.setBounds(150, 0, 100, 20);
        datePicker.setBounds(20, 30, 120, 20);

        add(titleLable);
        add(datePicker);
    }
}
