package mvc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TextPanel extends JPanel implements ChangeListener {
    Model<String> model;
    TextArea textArea;
    public TextPanel(Model<String> model, LayoutManager style) {
        this.model = model;
        textArea = new TextArea();
        textArea.setEditable(false);
        add(textArea);
        this.model.add(textArea.getText());
        setLayout(style);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        textArea.append(model.dataList.get(0) + "\n");
    }
}
