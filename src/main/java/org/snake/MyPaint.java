package org.snake;

import javax.swing.*;
import java.awt.*;

import static org.snake.Main.*;
import static org.snake.Main.cellPx;

public class MyPaint extends JPanel {
    public MyPaint() {
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, MaxX * cellPx, MaxY * cellPx);

        for (int x = 0; x < MaxX * cellPx; x = x + cellPx) {
            g.setColor(Color.yellow);
            g.drawLine(x, 0, x, MaxY * cellPx);
        }

        for (int y = 0; y < MaxY * cellPx; y += cellPx) {
            g.setColor(Color.yellow);
            g.drawLine(0, y, MaxX * cellPx, y);
        }
    }

    public static void main(String[] args) {
        JFrame j = new JFrame();
        j.setSize(400, 400);
        j.setTitle("Snake");
        j.setName("Snake");
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setLayout(new BorderLayout());
        j.setVisible(true);

        JPanel p = new JPanel();
        p.setSize(400, 400);
        p.setVisible(true);
        j.add(p);

        JTextArea textPanel = new JTextArea("    Your score: "+ 44);
        textPanel.setBackground(Color.getColor("#f2f2f2"));
        textPanel.setForeground(Color.BLUE);

        p.add(textPanel);
        //repaint();

    }

}
