package mvc;

import javax.swing.*;
import java.awt.*;

public class MVCTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        Model<String> model = new Model<>();

        TextPanel textPanel = new TextPanel(model, new FlowLayout());

        model.attach(textPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("Add Text");
        JTextField textField = new JTextField(25);
        button.addActionListener(e -> model.update(0, textField.getText()));

        buttonPanel.add(button);
        buttonPanel.add(textField);

        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
