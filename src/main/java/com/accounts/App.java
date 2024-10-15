package com.accounts;

import javax.swing.JFrame;

import com.accounts.panels.AddPanel;
import com.accounts.panels.FilterPanel;
import com.accounts.panels.HeadMenu;
import com.accounts.panels.ListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private HeadMenu buttonPanel;
    private AddPanel addPanel;
    private ListPanel listPanel;
    private FilterPanel filterPanel;

    public App() {

        setLayout(null);
        setTitle("Управление поездами");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 320);

        buttonPanel = new HeadMenu();
        addPanel = new AddPanel();
        listPanel = new ListPanel();
        filterPanel = new FilterPanel();

        buttonPanel.setBounds(0, 5, 650, 20);
        addPanel.setBounds(0, 25, 730, 320);
        listPanel.setBounds(0, 25, 730, 320);
        filterPanel.setBounds(0, 25, 730, 320);

        buttonPanel.addCarriageButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(listPanel);
                remove(filterPanel);
                add(addPanel);
                repaint();
            }
        });

        buttonPanel.listCarriagesButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(addPanel);
                remove(filterPanel);
                add(listPanel);
                repaint();
            }
        });

        buttonPanel.filterCarriagesButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(addPanel);
                remove(listPanel);
                add(filterPanel);
                repaint();
            }
        });

        add(buttonPanel);
        add(addPanel);
        add(filterPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
