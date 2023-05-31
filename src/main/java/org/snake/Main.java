package org.snake;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public final static Integer MaxY = 15;
    public final static Integer MaxX = 20;
    public final static Integer WIDTH = 600;
    public final static Integer HEIGHT = 450;


    public static void main(String[] args) {

        MainWindowJFame app = new MainWindowJFame(700, 500).getGameWindow();
        SplashScreen splashScreen = new SplashScreen(app);
        JPanel splash = splashScreen.getSplashScreen();

        splash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                splashScreen.clickSound();
                app.remove(splash);
                PlaygroundField playgroundField = new PlaygroundField(app);
            }
        });
      //

    }

}
