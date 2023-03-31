package chapt4.assignment15;

import javax.swing.*;
import java.awt.*;

public class ZoomTester {
    static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame("Car Icon");
        JPanel panel = new IconPanel();
        frame.add(panel);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setMaximumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}