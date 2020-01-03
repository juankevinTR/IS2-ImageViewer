package com.juankevintrujillo.controller;

import com.juankevintrujillo.ui.ImageDisplay;
import com.juankevintrujillo.ui.SwingImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    MainFrame() {
        this.setTitle("IS2 - Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();

        Color bgPanel = Color.decode("#0E192B"); //  #0E192B #0E294B #00825A #5BD36D #FFFFFF
        panel.setBackground(bgPanel);

        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return e -> imageDisplay.show(imageDisplay.current().prev());
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return e -> imageDisplay.show(imageDisplay.current().next());
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
