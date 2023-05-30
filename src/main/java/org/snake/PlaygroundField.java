package org.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.LinkedList;

public class PlaygroundField {

    JFrame gameFieldFrame;
    String audioOnClick = "src/main/resources/oneClick.wav";
    public JPanel[][] cells = new JPanel[Ball.MaxX][Ball.MaxY];
    Ball ball = new Ball();
    JPanel newPanel = new JPanel(new GridLayout(Ball.MaxY, Ball.MaxX));
    boolean check;
    LinkedList<Ball> balls = new LinkedList<>();

    public PlaygroundField(JFrame gameFieldFrame) {
        this.gameFieldFrame = gameFieldFrame;
    }


    PlaygroundField startGame() {


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

       // newPanel.setSize(600, 450);

        for (int j = 0; j < y; j++) {
            for (int z = 0; z < x; z++) {
                JPanel cell = new Cell(z, j);
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                newPanel.add(cell);
                cells[z][j] = cell;
            }
        }

        gameFieldFrame.add(newPanel);
        gameFieldFrame.revalidate();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);


        balls.add(ball);
        balls.add(new BallBody(ball.getX(), ball.getY()+1));
        balls.add(new BallBody(ball.getX(), ball.getY()+2));
        balls.add(new BallBody(ball.getX(), ball.getY()+3));

        for (Ball b: balls) {
            cells[b.getX()][b.getY()].add(b, BorderLayout.CENTER);
        }


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
                moveBalls();
            }
            case KeyEvent.VK_DOWN -> {
                check = ball.moveDown();
                moveBalls();
            }
            case KeyEvent.VK_LEFT -> {
                check = ball.moveLeft();
                moveBalls();
            }
            case KeyEvent.VK_RIGHT -> {
                check = ball.moveRight();
                moveBalls();
            }
            default -> {
            }

    }

        gameFieldFrame.pack();
        gameFieldFrame.repaint();
    }


    public void moveBalls() {

        if(check){

            balls.getLast().setX(BallBody.xHead); balls.getLast().setY(BallBody.yHead);
            balls.add(1, balls.getLast());

            for (Ball b:balls) {
                cells[b.getX()][b.getY()].add(b, BorderLayout.CENTER);
            }

        }
    }

}