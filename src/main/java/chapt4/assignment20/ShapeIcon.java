package chapt4.assignment20;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 An icon that contains a moveable shape.
 This code is not my own and is borrowed from the publisher's website.
 I have added comments anywhere I added to or edited code.
 */
public class ShapeIcon implements Icon
{
    public ShapeIcon(ArrayList<MoveableShape> shapes, // edited by Jonathan Stewart Thomas
                     int width, int height)
    {
        this.shapes = shapes; // edited by Jonathan Stewart Thomas
        this.width = width;
        this.height = height;
    }

    public int getIconWidth()
    {
        return width;
    }

    public int getIconHeight()
    {
        return height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (MoveableShape shape : shapes) { // for loop added by Jonathan Stewart Thomas
            shape.draw(g2);
        }
    }

    private final int width; // made final by Jonathan Stewart Thomas
    private final int height; // made final by Jonathan Stewart Thomas
    private final ArrayList<MoveableShape> shapes; // edited by Jonathan Stewart Thomas
}


