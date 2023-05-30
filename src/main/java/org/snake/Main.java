package org.snake;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {

        JFrame gameFieldFrame = new MainWindowJFame(600, 450).getGameWindow();
        JPanel splashScreen = new SplashScreen(gameFieldFrame).getSplashScreen();
        Playground playground = new Playground(gameFieldFrame);

        splashScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    gameFieldFrame.remove(splashScreen);
                    playground.startGame();

            }

        });


    }

}
