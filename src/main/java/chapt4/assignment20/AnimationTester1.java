package chapt4.assignment20;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        // this block of code was edited by Jonathan Stewart Thomas
        MoveableShape shape1 = new CarShape(0, 0, CAR_WIDTH);
        MoveableShape shape2 = new CarShape(CAR_WIDTH + 20, 0, CAR_WIDTH);
        ArrayList<MoveableShape> shapes = new ArrayList<>();
        shapes.add(shape1);
        shapes.add(shape2);
        ShapeIcon icon = new ShapeIcon(shapes,
                ICON_WIDTH, ICON_HEIGHT);

        JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, event ->
        {
            for (MoveableShape shape : shapes) { // for loop added by Jonathan Stewart Thomas
                shape.move();
            }
            label.repaint();
        });
        t.start();
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
}

