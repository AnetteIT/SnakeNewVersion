package org.snake;

import javax.swing.*;

public class Cell extends JPanel {

    int cellX;
    int cellY;

    public Cell(int cellX, int cellY) {
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }


}
