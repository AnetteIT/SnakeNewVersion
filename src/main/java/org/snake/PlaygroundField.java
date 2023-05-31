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
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import static org.snake.Main.*;

public class PlaygroundField extends JPanel  implements ActionListener  {

    boolean inGame = true;
    boolean check;
    int appleX;
    int appleY;

    JFrame app;
    InfoPanel info = new InfoPanel();
    public JPanel[][] cells = new JPanel[MaxX][Main.MaxY];
    Snake ball = new Snake();


    LinkedList<Snake> snakeBody = new LinkedList<>();
    ArrayList<Cell> freeCells = new ArrayList<>();
    Cell randomPointApple;


    public PlaygroundField(ProgramWindow app) {
        this.app = app;
        startGame();
        doDrawing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            startAppleTimer();
            checkApple();
            Toolkit.getDefaultToolkit().sync();
            repaint();

        } else {
            gameOver();
            repaint();
        }
    }


    void startGame() {

        JPanel newPanel = new JPanel();
        JPanel infoPanel = info.getInfoPanel(newPanel);
        infoPanel.setPreferredSize(new Dimension(MaxX*cellPx, cellPx*2));
        newPanel.setPreferredSize(new Dimension(MaxX*cellPx, MaxY*cellPx));
        app.setResizable(false);
        drawingCells(MaxX, MaxY, newPanel);
        app.add(infoPanel, BorderLayout.PAGE_START);
        app.add(newPanel, BorderLayout.PAGE_END);
        //app.revalidate();
        app.addKeyListener(new pressKey());
        ball.initStartSnake(this);
        app.pack();
        app.setVisible(true);
        app.repaint();

    }

    private void drawingCells(int x, int y, JPanel newPanel) {
        for (int j = 0; j < y; j++) {
            for (int z = 0; z < x; z++) {
                JPanel cell = new Cell(z, j);
                //cell.setSize(new Dimension(cellPx, cellPx));
                //cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                newPanel.add(cell);
                cells[z][j] = cell;
            }
        }
    }


    private void doDrawing() {

        if (inGame) {
            startAppleTimer();
            checkApple();
            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver();
        }
    }

    public void getApple() {

// заполнение списка свободных ячеек
        for (int x = 0; x < MaxX; x++) {
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



    public void startAppleTimer() {
        int rand = ThreadLocalRandom.current().nextInt(5000, 10000);
        Timer foodTimer = new Timer(rand, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeOldFood();
                getApple();
                app.repaint();
            }
        });
        foodTimer.start();
    }


    private void removeOldFood() {
        for (int x = 0; x < MaxX; x++) {
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




    private void gameOver() {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        JTextArea gameOver = new JTextArea(msg);
        gameOver.setForeground(Color.BLACK);
        gameOver.setFont(small);
        app.add(gameOver);
        repaint();
    }

    private void checkApple() {

        if ((ball.getX() == appleX) && (ball.getX() == appleY)) {
            removeOldFood();
            info.dots++;
            getApple();
        }
    }




    private class pressKey extends KeyAdapter {

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

            int n = (snakeBody.size());

            if (check) {

                snakeBody.get(n - 1).setX(Snake.xHead);
                snakeBody.get(n - 1).setY(Snake.yHead);
                snakeBody.add(1, snakeBody.get(n - 1));
                snakeBody.remove(n);

                for (Snake b : snakeBody) {
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


}



