package org.snake;

import javax.swing.*;
import java.awt.*;

public class MainWindowJFame {
    JFrame gameFieldFrame = new JFrame();


    int sizeX;
    int sizeY;

    public MainWindowJFame(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public JFrame getGameWindow() {

        gameFieldFrame.setSize(sizeX, sizeY);
        gameFieldFrame.setTitle("Snake");
        gameFieldFrame.setName("Snake");
        gameFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFieldFrame.setLocationRelativeTo(null);
        gameFieldFrame.setBackground(Color.BLACK);
        gameFieldFrame.setVisible(true);

        return gameFieldFrame;

    }





}
