package org.snake;

import javax.swing.*;

public class Ball {
    public static final Integer MaxX = 12;
    public static final Integer MaxY = 9;
    private int x=0;
    private int y=0;
    private final ImageIcon image = new ImageIcon("src/main/resources/ballIcon.png");
    JLabel ballLabel;

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

    public ImageIcon getImage() {
        return image;
    }


    boolean moveUP(){
        if (y >= 0 && y < MaxY) {
            if (y - 1 >= 0) {
                y--;
                return true;
            }
        }
        return false;
    }

    boolean moveDown(){

        if (y >= 0 && y < MaxY) {
            if (y + 1 < MaxY) {
                y++;
                return true;
            }
        }
        return false;
    }

    boolean moveLeft(){
        if (x >= 0 && x < Ball.MaxX) {
            if (x - 1 >= 0) {
                x--;
                return true;
            }
        }
        return false;
    }

    boolean moveRight(){
        if (x >= 0 && x < Ball.MaxX) {
            if (x + 1 < Ball.MaxX) {
                x++;
                return true;
            }
        }
        return false;

    }
}
