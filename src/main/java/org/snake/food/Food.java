package org.snake.food;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Food extends JLabel{
    protected int xMax;
    protected int yMax;
    protected Icon image;


    public Food(int xMax, int yMax) {
        super(null, new ImageIcon("src/main/resources/apple.gif"), CENTER);
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public Food() {
        super(null, new ImageIcon("src/main/resources/apple.gif"), CENTER);
    }

    public int getX() {
        return (int) ThreadLocalRandom.current().nextInt(0, xMax + 1);
    }

    public int getY() {
        return (int) ThreadLocalRandom.current().nextInt(0, yMax + 1);
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
}
