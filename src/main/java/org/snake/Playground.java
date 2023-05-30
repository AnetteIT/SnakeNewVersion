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
    String audioOnClick = "src/main/resources/korotkiy-zvuk-najatiya-na-odnu-klavishu.wav";

    public Playground(JFrame gameFieldFrame) {
        this.gameFieldFrame = gameFieldFrame;
    }


    void startGame() {


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





        JPanel newPanel = new JPanel(new GridLayout(y, x));
        newPanel.setSize(600, 450);

        JPanel[][] cells = new JPanel[x][y];

        for (int j = 0; j < y; j++) {
            for (int z = 0; z < x; z++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                newPanel.add(cell);
                cells[z][j] = cell;
                System.out.print(j + "=" + z);
                System.out.println("");
            }
        }

        gameFieldFrame.add(newPanel);
        gameFieldFrame.revalidate();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);


        Ball ball = new Ball();
        ball.setX(0);
        ball.setY(0);
        JLabel ballLabel = new JLabel(ball.getImage());
        ballLabel.setPreferredSize(new Dimension(50, 50));
        cells[0][0].add(ballLabel, 0);

        gameFieldFrame.pack();
        gameFieldFrame.repaint();
        gameFieldFrame.setVisible(true);

        gameFieldFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        int yy = ball.getY() - 1;
                        if (ball.getY() >= 0 && ball.getY() < Ball.MaxY) {
                            if (yy >= 0) {
                                ball.setY(ball.getY() - 1);
                                cells[ball.getX()][ball.getY()].add(ballLabel, 0);
                            }
                        }
                        break;

                    case KeyEvent.VK_DOWN:
                        int yy2 = ball.getY() + 1;
                        if (ball.getY() >= 0 && ball.getY() < Ball.MaxY) {
                            if (yy2 < Ball.MaxY) {
                                ball.setY(ball.getY() + 1);
                                cells[ball.getX()][ball.getY()].add(ballLabel, 0);
                            }
                        }
                        break;

                    case KeyEvent.VK_LEFT:
                        int xx = ball.getX() - 1;
                        if (ball.getX() >= 0 && ball.getX() < Ball.MaxX) {
                            if (xx >= 0) {
                                ball.setX(ball.getX() - 1);
                                cells[ball.getX()][ball.getY()].add(ballLabel, 0);
                            }
                        }
                        break;

                    case KeyEvent.VK_RIGHT:
                        int xx2 = ball.getX() + 1;
                        if (ball.getX() >= 0 && ball.getX() < Ball.MaxX) {
                            if (xx2 < Ball.MaxX) {
                                ball.setX(ball.getX() + 1);
                                cells[ball.getX()][ball.getY()].add(ballLabel, 0);
                            }
                        }
                        break;

                    default:
                        break;
                }


                gameFieldFrame.pack();
                gameFieldFrame.repaint();
                gameFieldFrame.setVisible(true);

            }
        });

    }


}
