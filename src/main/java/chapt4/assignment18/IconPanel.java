package chapt4.assignment18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IconPanel extends JPanel {
    Icon icon;
    public IconPanel(Icon icon) {
        this.icon = icon;
        Timer timer = new Timer(1000, updateClock());
        timer.start();
    }

    ActionListener updateClock() {
        return e -> getParent().getParent().repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        icon.paintIcon(this, g, getX(), getY());
    }
}
