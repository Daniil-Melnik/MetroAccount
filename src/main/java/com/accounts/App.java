package com.accounts;

import javax.swing.JFrame;

import com.accounts.panels.AddPanel;
import com.accounts.panels.HeadMenu;
import com.accounts.panels.ListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private HeadMenu buttonPanel;
    private AddPanel addPanel;
    private ListPanel listPanel;

    public App() {

        setLayout(null);
        setTitle("Управление поездами");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 290);

        buttonPanel = new HeadMenu();
        addPanel = new AddPanel();
        listPanel = new ListPanel();

        buttonPanel.setBounds(0, 5, 400, 20);
        addPanel.setBounds(0, 25, 480, 260);
        listPanel.setBounds(0, 25, 400, 260);

        buttonPanel.addCarriageButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(listPanel);
                add(addPanel);
                repaint();
            }
        });

        buttonPanel.listCarriagesButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(addPanel);
                add(listPanel);
                repaint();
            }
        });

        add(buttonPanel);
        add(addPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
