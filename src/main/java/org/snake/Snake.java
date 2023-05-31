package org.snake;

import javax.swing.*;
import java.awt.*;

public class Snake extends JLabel {
    protected int x = 5;
    protected int y = 3;
    protected Icon image;
    public static int xHead;
    public static int yHead;
    public static final Icon imageBody = new ImageIcon("src/main/resources/body.png");
    protected Boolean isBody;


    public Snake() {
        super(null, new ImageIcon("src/main/resources/up.gif"), CENTER);
        //setPreferredSize(new Dimension(50, 50));
        this.isBody = false;
    }


    public Snake(int x, int y) {
        super(null, new ImageIcon("src/main/resources/up.gif"), CENTER);
        //setPreferredSize(new Dimension(50, 50));
        this.x = x;
        this.y = y;
        this.isBody = false;
    }

    public Snake(int x, int y, Boolean isBody) {
        super(null, new ImageIcon("src/main/resources/body.png"), CENTER);
        //setPreferredSize(new Dimension(50, 50));
        this.x = x;
        this.y = y;
        this.isBody = isBody;
    }

    public Snake( Boolean isBody) {
        super(null, new ImageIcon("src/main/resources/body.png"), CENTER);
        //setPreferredSize(new Dimension(50, 50));
        this.x = x;
        this.y = y;
        this.isBody = isBody;
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
            default -> image = new ImageIcon("src/main/resources/right.gif");
        };
    }


    boolean moveUP() {
        if (y >= 0 && y < Main.MaxY) {
            if (y - 1 >= 0) {
                xHead = x;
                yHead = y;
                y--;
                setImage(Directions.UP);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveDown() {

        if (y >= 0 && y < Main.MaxY) {
            if (y + 1 < Main.MaxY) {
                xHead = x;
                yHead = y;
                y++;
                setImage(Directions.DOWN);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveLeft() {
        if (x >= 0 && x < Main.MaxX) {
            if (x - 1 >= 0) {
                xHead = x;
                yHead = y;
                x--;
                setImage(Directions.LEFT);
                setIcon(image);
                return true;
            }
        }
        return false;
    }

    boolean moveRight() {
        if (x >= 0 && x < Main.MaxX) {
            if (x + 1 < Main.MaxX) {
                xHead = x;
                yHead = y;
                x++;
                setImage(Directions.RIGHT);
                setIcon(image);
                return true;
            }
        }
        return false;

    }


    void initStartSnake(PlaygroundField playgroundField) {
        playgroundField.snakeBody.add(0, this);
        playgroundField.snakeBody.add(new Snake(getX(), getY() + 1, true));
        playgroundField.snakeBody.add(new Snake(getX(), getY() + 2, true));
        playgroundField.snakeBody.add(new Snake(getX(), getY() + 3, true));
        playgroundField.snakeBody.add(new Snake(getX(), getY() + 4, true));

        for (Snake b : playgroundField.snakeBody) {
            playgroundField.cells[b.getX()][b.getY()].add(b, BorderLayout.CENTER);
            if (b.isBody) {
                b.setImage(Directions.BODY);
                b.setIcon(b.getImage());
            }
        }
    }
}

