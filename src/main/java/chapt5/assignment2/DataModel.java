package chapt5.assignment2;

import java.util.ArrayList;
import javax.swing.event.*;

/**
 A Subject class for the observer pattern.
 This code is not my own and is borrowed from the publisher's website.
 I have added comments anywhere I added to or edited code.
 */
public class DataModel
{
    /**
     Constructs a DataModel object
     @param d the data to model
     */
    public DataModel(ArrayList<Double> d)
    {
        data = d;
        listeners = new ArrayList<>(); // edited by Jonathan Stewart Thomas
    }

    /**
     Constructs a DataModel object
     @return the data in an ArrayList
     */
    public ArrayList<Double> getData()
    {
        return data; // edited by Jonathan Stewart Thomas
    }

    /**
     Attach a listener to the Model
     @param c the listener
     */
    public void attach(ChangeListener c)
    {
        listeners.add(c);
    }

    /**
     Change the data in the model at a particular location
     @param location the index of the field to change
     @param value the new value
     */
    public void update(int location, double value)
    {
        data.set(location, value); // edited by Jonathan Stewart Thomas
        for (ChangeListener l : listeners)
        {
            l.stateChanged(new ChangeEvent(this));
        }
    }

    ArrayList<Double> data;
    ArrayList<ChangeListener> listeners;
}
