package org.snake;

import javax.swing.*;

public class Cell extends JPanel {

    int coordX;
    int coordY;

    public Cell(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}
