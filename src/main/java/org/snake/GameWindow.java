package org.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GameWindow {

    JFrame gameFieldFrame = new JFrame();
    JPanel panel = new JPanel();

    public JFrame getGameWindow() {

        gameFieldFrame.setSize(600, 450);
        gameFieldFrame.setTitle("Snake");
        gameFieldFrame.setName("Snake");
        gameFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFieldFrame.setLocationRelativeTo(null);
        gameFieldFrame.setBackground(Color.BLACK);
        gameFieldFrame.setVisible(true);

        // Создаем объект Clip и загружаем аудиофайл
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/udaryi-myacha-ob-pol2.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        gameFieldFrame.setVisible(true);

        ImageIcon image = new ImageIcon("src/main/resources/ball4.gif");
        panel.add(new JLabel(image));
        gameFieldFrame.add(panel);
        gameFieldFrame.setVisible(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // воспроизводим звуковой файл
                new Thread(() -> {
                    startGame();
                }).start();

            }
        });

        return gameFieldFrame;

    }

    private void startGame() {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/korotkiy-zvuk-najatiya-na-odnu-klavishu.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int x = Ball.MaxX;
        int y = Ball.MaxY;


        gameFieldFrame.remove(panel);


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
