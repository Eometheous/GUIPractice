package chapt5.assignment4;

import javax.swing.*;

public interface Zoomable extends Icon {
    void zoom(double zoomAmount);
    double getZoomLevel();
}
