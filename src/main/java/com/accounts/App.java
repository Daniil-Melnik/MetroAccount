package com.accounts;

import javax.swing.JFrame;
import javax.swing.JPanel;
// вынести панель кнопок в отдельный компонент JPanel

import com.accounts.panels.HeadMenu;

import javax.swing.JButton;

public class App extends JFrame {

    private HeadMenu buttonPanel;

    public App() {

        setLayout(null);

        setTitle("Управление поездами");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);

        buttonPanel = new HeadMenu();
        // buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 0, 400, 100);

        // addCarriageButton = new JButton("Добавить");
        // addCarriageButton.setBounds(0, 0, 110, 25);

        // listCarriagesButton = new JButton("Список");
        // listCarriagesButton.setBounds(115, 0, 110, 25);

        // buttonPanel.add(addCarriageButton);
        // buttonPanel.add(listCarriagesButton);

        add(buttonPanel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

