package chapt5.assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CarIcon implements Icon {
    private final int width;
    private final int height;
    private double zoomLevel;
    public CarIcon(int width, int height) {
        this.width = width;
        this.height = height;
        zoomLevel = 1.0;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Rectangle2D frameBody = new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight());
        double centerX = frameBody.getCenterX();
        double centerY = frameBody.getCenterY();
        double wheel1X = getXBody(centerX) + 8 * zoomLevel;
        double wheel1Y = getYBody(centerY) + height * zoomLevel;
        double wheel2X = getXBody(centerX) + (width - 8) * zoomLevel;
        double wheel2Y = getYBody(centerY) + height * zoomLevel;

        Rectangle2D body = new Rectangle2D.Double(getXBody(centerX), getYBody(centerY),
                width * zoomLevel, height * zoomLevel);

        Ellipse2D wheel1 = new Ellipse2D.Double();
        Ellipse2D wheel2 = new Ellipse2D.Double();
        wheel1.setFrameFromCenter(wheel1X, wheel1Y, wheel1X + 5 * zoomLevel, wheel1Y + 5 * zoomLevel);
        wheel2.setFrameFromCenter(wheel2X, wheel2Y, wheel2X + 5 * zoomLevel, wheel2Y + 5 * zoomLevel);

        Ellipse2D roof = new Ellipse2D.Double();
        roof.setFrameFromCenter(centerX, centerY - (height>>1) * zoomLevel,
                centerX + 15 * zoomLevel, centerY - (height>>1) + 13 * zoomLevel);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fill(body);
        g2.fill(roof);
        g2.setColor(Color.BLACK);
        g2.fill(wheel1);
        g2.fill(wheel2);
    }

    private double getYBody(double centerY) {
        return centerY - (height >> 1) * zoomLevel;
    }

    private double getXBody(double centerX) {
        return centerX - (width >> 1) * zoomLevel;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    public void zoom(Double amount) {
        zoomLevel += amount;
    }
}
