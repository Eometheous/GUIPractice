package chapt4.assignment18;

import javax.swing.*;
import java.awt.*;

public class ClockTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        JPanel panel = new IconPanel(new ClockIcon(80));
        frame.add(panel);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setMaximumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
