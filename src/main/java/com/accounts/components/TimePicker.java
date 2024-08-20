package com.accounts.components;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class TimePicker extends JPanel {
    private String[] hourVars;
    private String[] minuteVars;

    private JComboBox<String> hourCombobox;
    private JComboBox<String> minuteCombobox;

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
        setSize(200, 30);
        hourCombobox = new JComboBox<String>(hourVars);
        minuteCombobox = new JComboBox<String>(minuteVars);

        hourCombobox.setBounds(0, 0, 100, 30);
        minuteCombobox.setBounds(105, 0, 100, 30);

        add(hourCombobox);
        add(minuteCombobox);
    }
}
