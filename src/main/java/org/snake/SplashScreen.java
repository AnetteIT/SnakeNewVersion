package org.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class SplashScreen {

    JFrame gameFieldFrame;
    JPanel panel = new JPanel();
    String pathGifStartGame = "src/main/resources/splashBall.gif";
    String pathAudioStartGame = "src/main/resources/soundBall.wav";

    public SplashScreen(JFrame gameFieldFrame) {
        this.gameFieldFrame = gameFieldFrame;
    }

    public JPanel getSplashScreen() {
        try {
            ImageIcon image = new ImageIcon(pathGifStartGame);
            panel.add(new JLabel(image));
            gameFieldFrame.add(panel);
            gameFieldFrame.setVisible(true);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathAudioStartGame));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return panel;

    }




}
