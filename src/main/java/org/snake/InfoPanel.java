package org.snake;

import javax.swing.*;
import java.awt.*;

public class InfoPanel {

    protected int dots=0;
    protected int record=0;

    public InfoPanel() {
    }

    public JPanel getInfoPanel(JPanel newPanel) {
        Font font = new Font("Verdana", Font.BOLD, 15);
        newPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
      //  newPanel.setPreferredSize(new Dimension(MaxX*cellPx, cellPx));
        JPanel infoPanel = new JPanel();
        JTextArea textPanel = new JTextArea("    Your score: "+ dots);
        textPanel.setBackground(Color.getColor("#f2f2f2"));
        textPanel.setFont(font);
        textPanel.setForeground(Color.BLUE);
        JButton buttonStart = new JButton("Start again");
        buttonStart.setPreferredSize(new Dimension(140, 25));
        buttonStart.setFont(font);
        JButton buttonReset = new JButton("Reset Record");
        buttonReset.setPreferredSize(new Dimension(170, 25));
        buttonReset.setFont(font);
        infoPanel.add(buttonStart, BorderLayout.LINE_START);
        infoPanel.add(buttonReset, BorderLayout.LINE_START);
        infoPanel.add(textPanel, BorderLayout.WEST);
        return infoPanel;
    }
}
