package org.snake;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {

        JFrame mainWindowFrame = new MainWindowJFame(600, 450).getGameWindow();
        JPanel splashScreen = new SplashScreen(mainWindowFrame).getSplashScreen();
        PlaygroundField playgroundField = new PlaygroundField(mainWindowFrame);

        splashScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    mainWindowFrame.remove(splashScreen);
                    playgroundField.startGame();

            }

        });


    }

}
