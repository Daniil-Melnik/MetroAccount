package com.accounts.panels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;

public class AddPanel extends JPanel {

    private JLabel titleLable;
    private JXDatePicker datePicker;
    // private JXDatePicker timePicker;
    private JLabel dateLabel;
    // private JLabel timeLabel;

    public AddPanel() {
        setLayout(null);
        setSize(400, 280);

        datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        // timePicker = new JXDatePicker();
        // timePicker.setDate(Calendar.getInstance().getTime());
        // timePicker.setFormats(new SimpleDateFormat("h:mm a"));

        titleLable = new JLabel("Добавить вагон");
        dateLabel = new JLabel("Дата поездки:");
        // timeLabel = new JLabel("Время поездки:");

        titleLable.setBounds(150, 0, 100, 20);
        datePicker.setBounds(120, 30, 120, 25);
        // timePicker.setBounds(120, 55, 120, 25);
        dateLabel.setBounds(20, 30, 100, 25);
        // timeLabel.setBounds(20, 55, 100, 25);

        add(titleLable);
        add(datePicker);
        // add(timePicker);
        add(dateLabel);
        // add(timeLabel);
    }
}
