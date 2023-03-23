package chapt4.assignment15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class IconPanel extends JPanel {
    CarIcon carIcon = new CarIcon(40, 20);
    public IconPanel() {
        JButton zoomOut = new JButton("Zoom Out");
        zoomOut.addActionListener(zoom(-.25));

        JButton zoomIn = new JButton("Zoom In");
        zoomIn.addActionListener(zoom(.25));

        setLayout(new FlowLayout());
        add(zoomIn);
        add(zoomOut);
    }

    private ActionListener zoom(Double zoomAmount) {
        return e -> {
            carIcon.zoom(zoomAmount);
            getParent().getParent().repaint();
        };
    }
    @Override
    protected void paintComponent(Graphics g) {
        carIcon.paintIcon(this, g, 100, 100);
    }
}

