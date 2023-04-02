package chapt5.assignment4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ZoomableIconPanel extends JPanel implements ChangeListener {
    Zoomable icon;
    public ZoomableIconPanel(Zoomable icon) {
        this.icon = icon;
    }
    @Override
    protected void paintComponent(Graphics g) {
         icon.paintIcon(this, g, 100, 100);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();

        double zoom = ((double) slider.getValue() / 50);
        icon.zoom(zoom);
        getParent().getParent().repaint();
    }
}

