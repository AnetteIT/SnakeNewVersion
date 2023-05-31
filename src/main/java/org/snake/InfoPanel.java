package org.snake;

import javax.swing.*;
import java.awt.*;

public class InfoPanel {

    protected int dots=0;
    protected int record=0;

    public InfoPanel() {
    }

    public JPanel getInfoPanel(JPanel newPanel) {
        Font font = new Font("Verdana", Font.BOLD, 20);
        newPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        newPanel.setSize(Main.WIDTH, Main.HEIGHT);
        JPanel infoPanel = new JPanel();
        JTextArea textPanel = new JTextArea("       Snake Game!         Your score: "+ dots   +"        Your record: "+ record+"     "   );
        textPanel.setBackground(Color.getColor("#f2f2f2"));
        textPanel.setFont(font);
        textPanel.setForeground(Color.BLUE);
        JButton buttonStart = new JButton("Start again");
        buttonStart.setFont(font);
        JButton buttonReset = new JButton("Reset Record");
        buttonReset.setFont(font);
        infoPanel.add(buttonStart, BorderLayout.LINE_START);
        infoPanel.add(buttonReset, BorderLayout.LINE_START);
        infoPanel.add(textPanel, BorderLayout.LINE_END);
        return infoPanel;
    }
}
