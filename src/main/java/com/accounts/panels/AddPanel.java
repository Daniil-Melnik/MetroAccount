package com.accounts.panels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.accounts.Enums.CarriagesModels;
import com.accounts.components.TimePicker;

public class AddPanel extends JPanel {

    private JLabel titleLable;
    private JXDatePicker datePicker;
    private TimePicker timePicker;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JComboBox carriadgeType;
    private JLabel typeLabel;
    private JTextField numberCarriadge;
    private JLabel numberLabel;

    public AddPanel() {
        setLayout(null);
        setSize(400, 280);

        datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        timePicker = new TimePicker();

        carriadgeType = new JComboBox<>(CarriagesModels.values());

        numberCarriadge = new JTextField();

        titleLable = new JLabel("Добавить вагон");
        dateLabel = new JLabel("Дата поездки:");
        timeLabel = new JLabel("Время поездки:");
        typeLabel = new JLabel("Модель:");
        numberLabel = new JLabel("№ вагона:");

        titleLable.setBounds(150, 0, 100, 20);
        datePicker.setBounds(120, 60, 120, 25);
        timePicker.setBounds(120, 90, 250, 30);
        dateLabel.setBounds(20, 60, 100, 25);
        timeLabel.setBounds(20, 90, 100, 25);
        carriadgeType.setBounds(120, 120, 200, 25);
        typeLabel.setBounds(20, 120, 50, 25);
        numberLabel.setBounds(20, 30, 60, 25);
        numberCarriadge.setBounds(120, 30, 100, 25);

        add(titleLable);
        add(datePicker);
        add(timePicker);
        add(dateLabel);
        add(timeLabel);
        add(carriadgeType);
        add(typeLabel);
        add(numberCarriadge);
        add(numberLabel);
    }
}
