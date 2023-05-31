package org.snake;

import javax.swing.*;
import java.awt.*;

public class ProgramWindow extends JFrame {

    int sizeX;
    int sizeY;

    public ProgramWindow(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public ProgramWindow getGameWindow() {

        this.setSize(sizeX, sizeY);
        this.setTitle("Snake");
        this.setName("Snake");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setVisible(true);

        return this;

    }


}
