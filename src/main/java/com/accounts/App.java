package com.accounts;

import javax.swing.JFrame;

import com.accounts.panels.AddPanel;
import com.accounts.panels.HeadMenu;

public class App extends JFrame {

    private HeadMenu buttonPanel;
    private AddPanel addPanel;

    public App() {

        setLayout(null);
        setTitle("Управление поездами");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        buttonPanel = new HeadMenu();
        addPanel = new AddPanel();

        buttonPanel.setBounds(0, 0, 400, 20);
        addPanel.setBounds(0, 20, 400, 250);

        add(buttonPanel);
        add(addPanel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

