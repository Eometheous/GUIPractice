package chapt5.assignment4;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderTester {
    static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame("Car Icon");

        CarIcon carIcon = new CarIcon(40, 20);
        JPanel iconPanel = new ZoomableIconPanel(carIcon);

        JSlider slider = new JSlider(25, 200);
        slider.addChangeListener((ChangeListener) iconPanel);
        JPanel sliderPanel = new SliderPanel(slider);

        frame.setLayout(new BorderLayout());
        frame.add(iconPanel, BorderLayout.CENTER);
        frame.add(sliderPanel, BorderLayout.SOUTH);


        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setMaximumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}