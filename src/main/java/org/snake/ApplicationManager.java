package org.snake;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationManager {

    public static void main(String[] args) {

        MainWindowJFame window = new MainWindowJFame(600, 450);
        JFrame gameFieldFrame = window.getGameWindow();
        JPanel splashScreen = new SplashScreen(gameFieldFrame).getSplashScreen();

        splashScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread(() -> {
                    gameFieldFrame.remove(splashScreen);
                    new Playground(gameFieldFrame).startGame();
                }).start();
            }
        });

    }

}
