package org.snake;

import javax.swing.*;

public class PlayingField {

    public static void main(String[] args) {

        JFrame gameField  = new JFrame();
        gameField.setSize(600, 600);
        gameField.setTitle("Змейка");
        gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameField.setVisible(true);
        gameField.setLocationRelativeTo(null);

    }

}
