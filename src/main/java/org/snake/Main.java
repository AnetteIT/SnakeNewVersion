package org.snake;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public final static Integer MaxY = 20;
    public final static Integer MaxX = 20;
    public final static Integer cellPx = 30;


    public static void main(String[] args) {

        ProgramWindow app = new ProgramWindow(MaxX*cellPx+200, MaxY*cellPx+200).getGameWindow();
        app.setResizable(false);
        SplashScreen splashScreen = new SplashScreen(app);
        JPanel splash = splashScreen.getSplashScreen();

        splash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                splashScreen.clickSound();
                app.remove(splash);
                new PlaygroundField(app);
            }
        });

    }

}
