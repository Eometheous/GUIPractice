package chapt5.assignment2;

import java.util.ArrayList;

/**
 A class for testing an implementation of the Observer pattern.
 This code is not my own and is borrowed from the publisher's website.
 I have added comments anywhere I added to or edited code.
 */
public class ObserverTester
{
    /**
     Creates a DataModel and attaches barchart and textfield listeners
     @param args unused
     This code is not my own and is borrowed from the publisher's website.
     I have added comments anywhere I added to or edited code.
     */
    public static void main(String[] args)
    {
        ArrayList<Double> data = new ArrayList<>();

        // edited by Jonathan Stewart Thomas to get rid of deprecated code
        data.add(33.0);
        data.add(44.0);
        data.add(22.0);
        data.add(22.0);

        DataModel model = new DataModel(data);

        TextFrame frame = new TextFrame(model);
        frame.setLocationRelativeTo(null); // added by Jonathan Stewart Thomas to make frame at center of screen
        BarFrame barFrame = new BarFrame(model);
        barFrame.setLocation(frame.getX() + frame.getWidth(), frame.getY()); // added by Jonathan Stewart Thomas

        model.attach(barFrame);
        model.attach(frame);
    }
}
