package org.snake;

import javax.swing.*;

import static java.awt.Color.black;

public class GameField {

    public GameField() {
        JFrame gameField  = new JFrame();
        gameField.setSize(600, 600);
        gameField.setTitle("Snake");
        gameField.setName("Snake");
        gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameField.setLocationRelativeTo(null);
        gameField.setBackground(black);
        gameField.setVisible(true);

    }
}
