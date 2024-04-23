package com.akar42;

import javax.swing.JFrame;

import com.akar42.GUI.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Test Game of Life");
        mainFrame.setContentPane(mainFrame.getMainPanel());
        mainFrame.setSize(500,500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}