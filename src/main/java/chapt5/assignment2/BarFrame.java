package chapt5.assignment2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 A class that implements an Observer object that displays a barchart view of
 a data model.
 */
public class BarFrame extends JFrame implements ChangeListener
{
    /**
     Constructs a BarFrame object
     @param dataModel the data that is displayed in the barchart
     */
    public BarFrame(DataModel dataModel)
    {
        this.dataModel = dataModel;
        a = dataModel.getData();

        setLocation(0,200);
        setLayout(new BorderLayout());

        Icon barIcon = new Icon()
        {
            public int getIconWidth() { return ICON_WIDTH; }
            public int getIconHeight() { return ICON_HEIGHT; }
            public void paintIcon(Component c, Graphics g, int x, int y)
            {
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.red);

                double max = getMax();

                double barHeight = (double) getIconHeight() / a.size(); // edited by Jonathan Stewart Thomas

                int i = 0;
                for (Double value : a) // edited by Jonathan Stewart Thomas
                {
                    double barLength = getIconWidth() * value / max;

                    Rectangle2D.Double rectangle = new Rectangle2D.Double
                            (0, barHeight * i, barLength, barHeight);
                    i++;
                    g2.fill(rectangle);
                }
            }
        };
        // mouseListener added by Jonathan Stewart Thomas
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() - getInsets().left;
                int y = e.getY() - getInsets().top;
                int barHeight = barIcon.getIconHeight() / a.size();
                int clickedBar = Math.floorDiv(y, barHeight);
                double value;
                double max = getMax();
                value = (x / (double) barIcon.getIconWidth()) * max;
                dataModel.update(clickedBar, value);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        addMouseListener(mouseListener);

        add(new JLabel(barIcon));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    // getMax() extracted by Jonathan Stewart Thomas
    private double getMax() {
        double max = a.get(0); // edited by Jonathan Stewart Thomas
        for (Double v : a)
        {
            double val = v; // edited by Jonathan Stewart Thomas
            if (val > max)
                max = val;
        }
        return max;
    }

    /**
     Called when the data in the model is changed.
     @param e the event representing the change
     */
    public void stateChanged(ChangeEvent e)
    {
        a = dataModel.getData();
        repaint();
    }

    private ArrayList<Double> a;
    private final DataModel dataModel; // edited by Jonathan Stewart Thomas

    private static final int ICON_WIDTH = 200;
    private static final int ICON_HEIGHT = 200;
}
