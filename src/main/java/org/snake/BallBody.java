package org.snake;

import javax.swing.*;

public class BallBody extends Ball {
//    private int x1;
//    private int y1;
    public static int xHead;
    public static int yHead;
    private static Icon image = setImage(Directions.BODY);


    public BallBody() {
        super();
    }

    public BallBody(int x, int y) {
        super(x,y);
    }


}

