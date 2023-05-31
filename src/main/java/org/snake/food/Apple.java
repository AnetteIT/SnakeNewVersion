package org.snake.food;

import javax.swing.*;

public class Apple extends Food {


    public Apple(int xMax, int yMax) {
        super(xMax, yMax);
    }

    public Apple() {
        super();
    }

    @Override
    public Icon getImage() {
        return super.getImage();
    }

    @Override
    public void setImage(Icon image) {
        super.setImage(new ImageIcon("src/main/resources/apple.gif"));
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getLifeCycle() {
        return super.getLifeCycle();
    }

    @Override
    public int getPoints() {
        return super.getPoints();
    }
}
