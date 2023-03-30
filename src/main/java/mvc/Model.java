package mvc;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Model <T> {
    ArrayList<T> dataList;
    ArrayList<ChangeListener> listeners;
    public Model() {
        dataList = new ArrayList<>();
        listeners = new ArrayList<>();
    }
    public void add(T data) {
        dataList.add(data);
    }
    public void attach(ChangeListener listener) {
        listeners.add(listener);
    }
    public void update(int position, T updated) {
        dataList.set(position, updated);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(new ChangeEvent(this));
        }
    }
}
