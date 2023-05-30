package org.snake;

import javax.swing.*;

public class Ball {
    public static final Integer MaxX = 12;
    public static final Integer MaxY = 9;


    private int x;
    private int y;
    private final ImageIcon image = new ImageIcon("src/main/resources/bbbbbbbb.png");

    public Ball() {
        x = 0;
        y = 0;
    }
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImage() {
        return image;
    }
}
