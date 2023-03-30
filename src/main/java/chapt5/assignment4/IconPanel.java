package chapt5.assignment4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
public class IconPanel extends JPanel implements ChangeListener {
    CarIcon carIcon = new CarIcon(40, 20);
    public IconPanel() {
//        JButton zoomOut = new JButton("Zoom Out");
//        zoomOut.addActionListener(zoom(-.25));
//
//        JButton zoomIn = new JButton("Zoom In");
//        zoomIn.addActionListener(zoom(.25));
//
//        setLayout(new FlowLayout());
//        add(zoomIn);
//        add(zoomOut);
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

    @Override
    public void stateChanged(ChangeEvent e) {

        getParent().getParent().repaint();
    }
}

