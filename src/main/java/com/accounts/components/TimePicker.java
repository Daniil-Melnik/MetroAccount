package com.accounts.components;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePicker extends JPanel {
    private String[] hourVars;
    private String[] minuteVars;

    private JComboBox<String> hourCombobox;
    private JComboBox<String> minuteCombobox;

    private JLabel hourLabel;
    private JLabel minutLabel;

    private void makeHourVars() {
        hourVars = new String[24];
        for (int i = 0; i < 24; i++) {
            hourVars[i] = Integer.toString(i);
        }
    }

    private void makeMinutesVars() {
        minuteVars = new String[60];
        for (int i = 0; i < 60; i++) {
            minuteVars[i] = i < 10 ? "0" + i : Integer.toString(i);
        }
    }

    public TimePicker() {
        makeHourVars();
        makeMinutesVars();

        setLayout(null);
        setSize(250, 30);

        hourCombobox = new JComboBox<String>(hourVars);
        hourCombobox.setSelectedIndex(8);
        minuteCombobox = new JComboBox<String>(minuteVars);
        hourLabel = new JLabel("ч.");
        minutLabel = new JLabel("мин.");

        hourCombobox.setBounds(0, 0, 50, 25);
        minuteCombobox.setBounds(70, 0, 50, 25);
        hourLabel.setBounds(53, 0, 20, 25);
        minutLabel.setBounds(123, 0, 80, 25);

        add(hourCombobox);
        add(minuteCombobox);
        add(hourLabel);
        add(minutLabel);
    }
}
