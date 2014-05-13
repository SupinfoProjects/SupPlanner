import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowBase extends JFrame implements ActionListener
{
    protected JPanel panel;
    protected Dimension dimensions;

    public WindowBase(Dimension dimensions)
    {
        // Dimensions
        this.dimensions = dimensions;
        // Panel
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setMaximumSize(this.dimensions);
        this.setContentPane(panel);
        // Fenêtre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        this.setSize(this.dimensions.width, this.dimensions.height);
        this.setMaximumSize(this.dimensions);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
