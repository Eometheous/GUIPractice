package chapt4.assignment20;

import java.awt.*;

/**
 A shape that can be moved around.
 This code is not my own and is borrowed from the publisher's website.
 I have added comments anywhere I added to or edited code.
 */
public interface MoveableShape
{
    /**
     Draws the shape.
     @param g2 the graphics context
     */
    void draw(Graphics2D g2);
    /**
     Moves the shape.
     It is up to the shape to move itself, for example by tracking the time since
     its last movement, its position, and velocity.
     */
    void move();
}
