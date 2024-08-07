package com.accounts;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class App extends JFrame {

    private JPanel buttonPanel;
    private JButton addCarriageButton;
    private JButton listCarriagesButton;

    public App() {
        setTitle("Управление поездами");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        addCarriageButton = new JButton("Добавить вагон");
        listCarriagesButton = new JButton("Список вагонов");

        buttonPanel.add(addCarriageButton);
        buttonPanel.add(listCarriagesButton);

        add(buttonPanel, BorderLayout.NORTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

