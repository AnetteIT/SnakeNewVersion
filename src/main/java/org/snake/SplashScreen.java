package org.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SplashScreen extends JPanel {

    JFrame app;
    JPanel panel = new JPanel();
    String pathGifStartGame = "src/main/resources/splashBall.gif";
    String pathAudioStartGame = "src/main/resources/soundBall.wav";
    String audioOnClick = "src/main/resources/oneClick.wav";

    public SplashScreen(JFrame app) {
        this.app = app;
    }

    public JPanel getSplashScreen() {

            ImageIcon image = new ImageIcon(pathGifStartGame);
            panel.add(new JLabel(image));
            panel.setBackground(Color.WHITE);
            app.add(panel, BorderLayout.PAGE_START);

            app.setVisible(true);

//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathAudioStartGame));
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();



        return panel;

    }

    public void clickSound() {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioOnClick));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



}
