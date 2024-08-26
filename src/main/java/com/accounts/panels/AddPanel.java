package com.accounts.panels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.accounts.Enums.CarriagesModels;
import com.accounts.components.TimePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

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
    private JButton submit;

    public AddPanel() {
        setLayout(null);
        setSize(400, 280);

        Font font15 = new Font("Arial", Font.BOLD, 15);

        datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        timePicker = new TimePicker();

        carriadgeType = new JComboBox<>(CarriagesModels.values());

        numberCarriadge = new JTextField();

        submit = new JButton("Добавить");

        titleLable = new JLabel("Добавить вагон");
        titleLable.setFont(font15);

        dateLabel = new JLabel("Дата поездки:");
        timeLabel = new JLabel("Время поездки:");
        typeLabel = new JLabel("Модель:");
        numberLabel = new JLabel("№ вагона:");

        titleLable.setBounds(120, 5, 150, 20);
        datePicker.setBounds(120, 60, 120, 25);
        timePicker.setBounds(120, 90, 250, 30);
        dateLabel.setBounds(20, 60, 100, 25);
        timeLabel.setBounds(20, 90, 100, 25);
        carriadgeType.setBounds(120, 120, 200, 25);
        typeLabel.setBounds(20, 120, 50, 25);
        numberLabel.setBounds(20, 30, 60, 25);
        numberCarriadge.setBounds(120, 30, 100, 25);
        submit.setBounds(0, 150, 390, 30);

        add(titleLable);
        add(datePicker);
        add(timePicker);
        add(dateLabel);
        add(timeLabel);
        add(carriadgeType);
        add(typeLabel);
        add(numberCarriadge);
        add(numberLabel);
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CarriagesModels cm = (CarriagesModels) carriadgeType.getSelectedItem();
                System.out.println(cm.name());
            }
        });
    }
}
