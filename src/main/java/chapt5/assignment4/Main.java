package chapt5.assignment4;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Main {
    static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame("Car Icon");
        JPanel iconPanel = new IconPanel();

        JSlider slider = new JSlider();
        slider.setMinimum(4);
        slider.setMinimum(0);
        slider.setValue(1);
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