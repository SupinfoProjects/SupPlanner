import sun.org.mozilla.javascript.tools.debugger.Dim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseWindow extends JFrame implements ActionListener
{
    protected JPanel panel;
    protected Dimension dimensions;

    public BaseWindow(Dimension dimensions)
    {
        this.dimensions = dimensions;
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.setContentPane(panel);
        this.panel.setMaximumSize(this.dimensions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
