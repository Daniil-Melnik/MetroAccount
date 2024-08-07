package com.accounts;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class App extends JFrame {

    public App() {
        setTitle("Управление поездами");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton addCarriageButton = new JButton("Добавить вагон");
        JButton listCarriagesButton = new JButton("Список вагонов");

        buttonPanel.add(addCarriageButton);
        buttonPanel.add(listCarriagesButton);

        add(buttonPanel, BorderLayout.NORTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        // Вызов конструктора для создания и отображения окна
        new App();
    }
}

