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
import com.accounts.Enums.Factories;
import com.accounts.Enums.LinesTitles;
import com.accounts.JsonAPI.JsonIO;
import com.accounts.JsonAPI.Vagon;
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
    private JLabel lineTieleLabel;
    private JComboBox<CarriagesModels> carriadgeType;
    private JComboBox<LinesTitles> lineTitle;
    private JComboBox<Factories> factoryTitle;
    private JLabel typeLabel;
    private JTextField numberCarriadge;
    private JLabel numberLabel;
    private JLabel factoryTiteleLabel;
    private JButton submit;

    public AddPanel() {
        setLayout(null);
        setSize(400, 320);

        Font font15 = new Font("Arial", Font.BOLD, 15);

        datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        timePicker = new TimePicker();

        carriadgeType = new JComboBox<>(CarriagesModels.values());
        lineTitle = new JComboBox<>(LinesTitles.values());
        factoryTitle = new JComboBox<>(Factories.values());

        numberCarriadge = new JTextField();

        submit = new JButton("Добавить");

        titleLable = new JLabel("Добавить вагон");
        titleLable.setFont(font15);

        dateLabel = new JLabel("Дата поездки:");
        timeLabel = new JLabel("Время поездки:");
        typeLabel = new JLabel("Модель:");
        numberLabel = new JLabel("№ вагона:");
        lineTieleLabel = new JLabel("Линия:");
        factoryTiteleLabel = new JLabel("Изготовитель:");

        titleLable.setBounds(170, 5, 150, 20);
        datePicker.setBounds(120, 60, 120, 25);
        timePicker.setBounds(120, 90, 250, 30);
        dateLabel.setBounds(20, 60, 100, 25);
        timeLabel.setBounds(20, 90, 100, 25);
        carriadgeType.setBounds(120, 120, 200, 25);
        typeLabel.setBounds(20, 120, 50, 25);
        numberLabel.setBounds(20, 30, 60, 25);
        numberCarriadge.setBounds(120, 30, 100, 25);
        lineTitle.setBounds(120, 150, 200, 25);
        factoryTitle.setBounds(120, 180, 200, 25);
        lineTieleLabel.setBounds(20, 150, 60, 25);
        factoryTiteleLabel.setBounds(20, 180, 100, 25);

        submit.setBounds(0, 220, 480, 35);

        add(titleLable);
        add(datePicker);
        add(timePicker);
        add(dateLabel);
        add(timeLabel);
        add(carriadgeType);
        add(typeLabel);
        add(numberCarriadge);
        add(numberLabel);
        add(lineTitle);
        add(lineTieleLabel);
        add(factoryTitle);
        add(factoryTiteleLabel);
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int addNumber;
                String addType;
                String addLine;
                String addDate;
                String addTime;
                String addFactory;

                CarriagesModels ct = (CarriagesModels) carriadgeType.getSelectedItem();
                LinesTitles lt = (LinesTitles) lineTitle.getSelectedItem();
                Factories ft = (Factories) factoryTitle.getSelectedItem();

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                addNumber = Integer.parseInt(numberCarriadge.getText());
                addType = ct.name().toString();
                addLine = lt.name().toString();
                addDate = df.format(datePicker.getDate());
                addTime = timePicker.getSelectedTime();

                Vagon addVagon = new Vagon(addNumber, addType, addLine, addDate, addTime, );

                // addVagon.printVagonInfo();

                try {
                    JsonIO.writeJsonSingle(addVagon);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
