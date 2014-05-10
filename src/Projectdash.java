import javax.swing.*;
import java.awt.*;

public class Projectdash extends JFrame
{
    private JButton[] buttons;
    private JPanel panel;
    private Project[] projects;

    public Projectdash(Point _location, Project[] _projects)
    {
        // Boutons
        this.buttons = new JButton[6];
        buttons[0] = new JButton("");
        buttons[1] = new JButton("");
        buttons[2] = new JButton("");
        buttons[3] = new JButton("");
        buttons[4] = new JButton("");
        buttons[5] = new JButton("");
        // Projects
        this.projects = new Project[_projects.length];
        System.arraycopy(_projects, 0, this.projects, 0, this.projects.length);
        // Fenêtre
        this.setLocation(_location);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        this.setSize(500, 400);
        this.setVisible(true);
        // Panel
        this.panel = new JPanel();
        for (JButton b : this.buttons)
        {
            b.setVisible(true);
            b.setSize(150, 75);
            b.setMaximumSize(new Dimension(150, 75));
            b.setText("");
            this.panel.add(b);
        }
        this.panel.setLayout(new GridBagLayout());
        this.setContentPane(panel);
    }

    public void showPage(int id)
    {
        if (id > this.projects.length / 6)
            return;
        int i = 0;
        for (JButton b : this.buttons)
        {
            if (i < this.projects.length) {
                String text = this.projects[i].getTitle().length() > 7
                        ? this.projects[i].getTitle().substring(0, 7) + "..."
                        : this.projects[i].getTitle();
                b.setText(text);
                b.setVisible(true);
            }
            else
            {
                b.setVisible(false);
            }
            i++;
        }
    }
}
