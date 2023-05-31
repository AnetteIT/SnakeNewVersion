package org.snake.food;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Food extends JLabel{
    protected int xMax;
    protected int yMax;
    protected int lifeCycle = 1000;
    protected final int points = 1;
    protected Icon image;


    public Food(int xMax, int yMax) {
        super(null, new ImageIcon("src/main/resources/apple.gif"), CENTER);
        this.xMax = xMax;
        this.yMax = yMax;
        this.lifeCycle = ThreadLocalRandom.current().nextInt(5000, 10000);
    }

    public Food() {
        super(null, new ImageIcon("src/main/resources/apple.gif"), CENTER);
        this.lifeCycle = ThreadLocalRandom.current().nextInt(5000, 10000);
    }

    public int getX() {
        return (int) ThreadLocalRandom.current().nextInt(0, xMax + 1);
    }

    public int getY() {
        return (int) ThreadLocalRandom.current().nextInt(0, yMax + 1);
    }

    public int getLifeCycle() {
        return lifeCycle;
    }

    public int getPoints() {
        return points;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
}
