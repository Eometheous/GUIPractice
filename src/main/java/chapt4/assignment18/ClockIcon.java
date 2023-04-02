package chapt4.assignment18;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClockIcon implements Icon {
    private final GregorianCalendar calendar = new GregorianCalendar();
    private final int radius;
    public ClockIcon(int radius) {
        calendar.getTime();
        this.radius = radius;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Rectangle2D frameBody = new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight());
        double centerX = frameBody.getCenterX();
        double centerY = frameBody.getCenterY();
        Ellipse2D clockBody = new Ellipse2D.Double();
        clockBody.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        calendar.setTime(Date.from(Instant.now()));
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        double hourX = centerX - (double)radius / 2 * Math.sin(((((double) hour)/12) * 360 ) * (Math.PI / 180) * -1);
        double hourY = centerY - (double)radius / 2 * Math.cos(((((double) hour)/12) * 360 ) * (Math.PI / 180) * -1);
        double minuteX = centerX - radius * Math.sin(((((double) minute)/60) * 360 ) * (Math.PI / 180) * -1);
        double minuteY = centerY - radius * Math.cos(((((double) minute)/60) * 360 ) * (Math.PI / 180) * -1);
        double secondX = centerX - radius * Math.sin(((((double) second)/60) * 360 ) * (Math.PI / 180) * -1);
        double secondY = centerY - radius * Math.cos(((((double) second)/60) * 360 ) * (Math.PI / 180) * -1);
        System.out.printf("%d %d %d \n", hour, minute, second);

        Line2D hourHand = new Line2D.Double(centerX, centerY, hourX, hourY);
        Line2D minuteHand = new Line2D.Double(centerX, centerY, minuteX,  minuteY);
        Line2D secondHand = new Line2D.Double(centerX, centerY, secondX, secondY);

        Graphics2D g2 = (Graphics2D) g;
        g2.draw(clockBody);
        g2.draw(hourHand);
        g2.draw(minuteHand);
        g2.setPaint(Color.RED);
        g2.draw(secondHand);
    }

    @Override
    public int getIconWidth() {
        return radius * 2;
    }

    @Override
    public int getIconHeight() {
        return radius * 2;
    }
}
