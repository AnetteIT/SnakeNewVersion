package org.snake;

import org.snake.food.Apple;
import org.snake.food.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PlaygroundField extends JPanel  implements ActionListener  {

    boolean inGame = true;
    private Timer foodTimer;
    boolean check;
    int appleX;
    int appleY;

    JFrame app;
    InfoPanel info = new InfoPanel();
    public JPanel[][] cells = new JPanel[Main.MaxX][Main.MaxY];
    Snake ball = new Snake();


    ArrayList<Snake> balls = new ArrayList<>();
    ArrayList<Cell> freeCells = new ArrayList<>();
    Cell randomPointApple;


    public PlaygroundField(MainWindowJFame app) {
        this.app = app;
        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            repaint();
        }
        else {
            foodTimer.stop();
            repaint();
        }
    }

    private void refresh(Graphics g) {
        getApple(g);
        startAppleTimer(g);
        checkApple(g);
        repaint();
    }


    void startGame() {

        JPanel newPanel = new JPanel(new GridLayout(Main.MaxY, Main.MaxX));
        JPanel infoPanel = info.getInfoPanel(newPanel);
        drawingCells(Main.MaxX, Main.MaxY, newPanel);
        app.add(infoPanel, BorderLayout.PAGE_START);
        app.add(newPanel, BorderLayout.CENTER);
        app.revalidate();
        app.repaint();
        app.setVisible(true);
        app.addKeyListener(new pressKey());
        ball.initStartSnake(this);
        app.pack();
        app.repaint();
        app.setVisible(true);

    }

    private void drawingCells(int x, int y, JPanel newPanel) {
        for (int j = 0; j < y; j++) {
            for (int z = 0; z < x; z++) {
                JPanel cell = new Cell(z, j);
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                newPanel.add(cell);
                cells[z][j] = cell;
            }
        }
    }


    private void doDrawing(Graphics g) {

        if (inGame) {
            startAppleTimer(g);
            checkApple(g);
            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);
        }
    }

    public void getApple(Graphics g) {

// заполнение списка свободных ячеек
        for (int x = 0; x < Main.MaxX; x++) {
            for (int y = 0; y < Main.MaxY; y++) {
                if (cells[x][y].getComponentCount() == 0) {
                    freeCells.add(new Cell(x, y));
                }
            }
        }

// если есть свободные ячейки, выбираем случайную и создаем на ней объект типа Food
        if (!freeCells.isEmpty()) {
            int index = (int) (Math.random() * freeCells.size());
            randomPointApple = freeCells.get(index);
            Food food = new Apple();
            cells[randomPointApple.cellX][randomPointApple.cellY].add(food, BorderLayout.CENTER);
            appleX = randomPointApple.cellX;
            appleY = randomPointApple.cellY;
        }
    }



    public void startAppleTimer(Graphics g) {
        int rand = ThreadLocalRandom.current().nextInt(5000, 10000);
        foodTimer = new Timer(rand, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeOldFood();
                getApple(g);
                app.repaint();
            }
        });
        foodTimer.start();
    }


    private void removeOldFood() {
        for (int x = 0; x < Main.MaxX; x++) {
            for (int y = 0; y < Main.MaxY; y++) {
                Component[] components = cells[x][y].getComponents();
                for (Component component : components) {
                    if (component instanceof Apple) {
                        cells[x][y].remove(component);
                        return;
                    }
                }
            }
        }
    }




    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (Main.WIDTH - metr.stringWidth(msg)) / 2, Main.HEIGHT / 2);
    }

    private void checkApple(Graphics g) {

        if ((ball.getX() == appleX) && (ball.getX() == appleY)) {
            removeOldFood();
            info.dots++;
            getApple(g);
        }
    }




    private class pressKey extends KeyAdapter implements org.snake.pressKey {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            switch (key) {
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

            app.pack();
            app.repaint();
        }


        public void moveBalls() {

            int n = (balls.size());

            if (check) {

                balls.get(n - 1).setX(Snake.xHead);
                balls.get(n - 1).setY(Snake.yHead);
                balls.add(1, balls.get(n - 1));
                balls.remove(n);

                for (Snake b : balls) {
                    if (b.isBody) {
                        b.setImage(Directions.BODY);
                        b.setIcon(b.getImage());
                    }
                    cells[b.getX()][b.getY()].add(b, BorderLayout.CENTER);
                }
                app.repaint();
            }
        }




    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }




}



