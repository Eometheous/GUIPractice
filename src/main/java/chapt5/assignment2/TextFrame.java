package chapt5.assignment2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/**
 A class for displaying the model as a column of textfields in a frame.
 This code is not my own and is borrowed from the publisher's website.
 I have added comments anywhere I added to or edited code.
 */
public class TextFrame extends JFrame implements ChangeListener // Jonathan Stewart Thomas implemented ChangeListener
{
    /**
     Constructs a JFrame that contains the textfields containing the data
     in the model.
     @param d the model to display
     */
    public TextFrame(DataModel d)
    {
        dataModel = d;

        final Container contentPane = this.getContentPane();
        setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        ArrayList<Double> a = dataModel.getData();
        fieldList = new JTextField[a.size()];

        // A listener for action events in the text fields
        ActionListener l = e -> {       // edited by Jonathan Stewart Thomas to make it lambda
            // Figure out which field generated the event
            JTextField c = (JTextField) e.getSource();
            int i = 0;
            int count = fieldList.length;
            while (i < count && fieldList[i] != c)
                i++;

            String text = c.getText().trim();

            try
            {
                double value = Double.parseDouble(text);
                dataModel.update(i, value);
            }
            catch (Exception exc)
            {
                c.setText("Error.  No update");
            }
        };

        final int FIELD_WIDTH = 11;
        for (int i = 0; i < a.size(); i++)
        {
            JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
            textField.addActionListener(l);
            add(textField);
            fieldList[i] = textField;
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    DataModel dataModel;
    JTextField[] fieldList;

    // Jonathan Stewart Thomas added stateChanged from implementing ChangeListener
    @Override
    public void stateChanged(ChangeEvent e) {
        for (int i = 0; i < fieldList.length; i++) {
            fieldList[i].setText(String.format("%.1f", dataModel.getData().get(i)));
        }
    }
}
