package org.snake;

import javax.swing.*;
import java.awt.*;

public class Ball extends JLabel {
    public static final Integer MaxX = 15;
    public static final Integer MaxY = 10;
    protected int x = 5;
    protected int y = 3;
    protected Icon image;


    public Ball() {
        super(null, new ImageIcon("src/main/resources/right2.gif"), CENTER);
        setPreferredSize(new Dimension(48, 48));
    }


    public Ball( int x, int y) {
        super(null, new ImageIcon("src/main/resources/right2.gif"), CENTER);
        setPreferredSize(new Dimension(48, 48));
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

    public Icon getImage() {
        return image;
    }

    public Icon setImage(Directions directions) {
        return switch (directions) {
            case LEFT -> image = new ImageIcon("src/main/resources/left.gif");
            case UP -> image = new ImageIcon("src/main/resources/up.gif");
            case DOWN -> image = new ImageIcon("src/main/resources/down.gif");
            case BODY -> image = new ImageIcon("src/main/resources/body.png");
            default -> image = new ImageIcon("src/main/resources/right2.gif");
        };
    }


    boolean moveUP() {
        if (y >= 0 && y < MaxY) {
            if (y - 1 >= 0) {
                BallBody.xHead = x;
                BallBody.yHead = y;
                y--;
                setImage(Directions.UP);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveDown() {

        if (y >= 0 && y < MaxY) {
            if (y + 1 < MaxY) {
                BallBody.xHead = x;
                BallBody.yHead = y;
                y++;
                setImage(Directions.DOWN);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveLeft() {
        if (x >= 0 && x < Ball.MaxX) {
            if (x - 1 >= 0) {
                BallBody.xHead = x;
                BallBody.yHead = y;
                x--;
                setImage(Directions.LEFT);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveRight() {
        if (x >= 0 && x < Ball.MaxX) {
            if (x + 1 < Ball.MaxX) {
                BallBody.xHead = x;
                BallBody.yHead = y;
                x++;
                setImage(Directions.RIGHT);
                setIcon(image);
                return true;
            }
        }
        return false;

    }

}

