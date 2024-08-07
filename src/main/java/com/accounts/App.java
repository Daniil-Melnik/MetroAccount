package com.accounts;

import javax.swing.JFrame;
import javax.swing.JPanel;

// import java.awt.Color;

import javax.swing.JButton;

// import java.awt.FlowLayout;
// import java.awt.BorderLayout;

public class App extends JFrame {

    private JPanel buttonPanel;
    private JButton addCarriageButton;
    private JButton listCarriagesButton;

    public App() {

        setLayout(null);

        setTitle("Управление поездами");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 0, 400, 100);

        addCarriageButton = new JButton("Добавить вагон");
        addCarriageButton.setBounds(0, 0, 100, 30);

        listCarriagesButton = new JButton("Список вагонов");
        listCarriagesButton.setBounds(85, 0, 100, 30);

        buttonPanel.add(addCarriageButton);
        buttonPanel.add(listCarriagesButton);

        add(buttonPanel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

