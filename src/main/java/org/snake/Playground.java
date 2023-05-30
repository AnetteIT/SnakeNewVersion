package org.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class Playground {

    JFrame gameFieldFrame;
    String audioOnClick = "src/main/resources/oneClick.wav";
    public JPanel[][] cells = new JPanel[Ball.MaxX][Ball.MaxY];
    Ball ball = new Ball();
    JPanel newPanel = new JPanel(new GridLayout(Ball.MaxY, Ball.MaxX));
    boolean check;

    public Playground(JFrame gameFieldFrame) {
        this.gameFieldFrame = gameFieldFrame;
    }


    Playground startGame() {


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioOnClick));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int x = Ball.MaxX;
        int y = Ball.MaxY;

        newPanel.setSize(600, 450);

        for (int j = 0; j < y; j++) {
            for (int z = 0; z < x; z++) {
                JPanel cell = new Cell(z, j);
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                newPanel.add(cell);
                cells[z][j] = cell;
            }
        }

        gameFieldFrame.add(newPanel);
        gameFieldFrame.revalidate();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);

        ball.ballLabel = new JLabel(ball.getImage());
    //    ball.ballLabel.setPreferredSize(new Dimension(50, 50));
        cells[ball.getX()][ball.getY()].add(ball.ballLabel, 0);

        gameFieldFrame.pack();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);

        gameFieldFrame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    pressKey(keyCode);
                }
        });

        return this;
    }






    private void pressKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                check = ball.moveUP();
                    moveBall();
            }
            case KeyEvent.VK_DOWN -> {
                check = ball.moveDown();
                    moveBall();
            }
            case KeyEvent.VK_LEFT -> {
                check = ball.moveLeft();
                    moveBall();
            }
            case KeyEvent.VK_RIGHT -> {
                check = ball.moveRight();
                    moveBall();
            }
            default -> {
            }

    }

        gameFieldFrame.pack();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);
    }


    public void moveBall() {
        if (check){
        cells[ball.getX()][ball.getY()].add(ball.ballLabel,0);
        }
    }

}