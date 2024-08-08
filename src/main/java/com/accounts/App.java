package com.accounts;

import javax.swing.JFrame;

import com.accounts.panels.HeadMenu;

public class App extends JFrame {

    private HeadMenu buttonPanel;

    public App() {

        setLayout(null);
        setTitle("Управление поездами");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        buttonPanel = new HeadMenu();

        buttonPanel.setBounds(0, 0, 400, 50);

        add(buttonPanel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

