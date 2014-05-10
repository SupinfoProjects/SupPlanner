import javax.swing.*;
import java.awt.*;

public class Projectdash extends JFrame
{
    private JButton[] buttons;
    private JButton previousPage, nextPage, admin, back;
    private JPanel panel;
    private Project[] projects;
    private Dimension dimensions = new Dimension(400, 200);
    private int pageID;

    public Projectdash(Point _location, Project[] _projects)
    {
        // Fenêtre
        this.setLocation(_location);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        this.setSize(this.dimensions.width, this.dimensions.height);
        this.setMaximumSize(this.dimensions);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        // Boutons
        this.buttons = new JButton[6];
        buttons[0] = new JButton("");
        buttons[1] = new JButton("");
        buttons[2] = new JButton("");
        buttons[3] = new JButton("");
        buttons[4] = new JButton("");
        buttons[5] = new JButton("");
        // Previous page
        previousPage = new JButton("<");
        previousPage.setContentAreaFilled(false);
        previousPage.setLayout(null);
        previousPage.setFocusPainted(false);
        previousPage.setBackground(Color.white);
        previousPage.setContentAreaFilled(true);
        previousPage.setBounds(10, this.dimensions.height - 50, 50, 20);
        previousPage.setVisible(true);
        // Next page
        nextPage = new JButton(">");
        nextPage.setContentAreaFilled(false);
        nextPage.setLayout(null);
        nextPage.setFocusPainted(false);
        nextPage.setBackground(Color.white);
        nextPage.setContentAreaFilled(true);
        nextPage.setBounds(340, this.dimensions.height - 50, 50, 20);
        nextPage.setVisible(true);
        // Buttons
        for (JButton b : this.buttons)
        {
            b.setContentAreaFilled(false);
            b.setLayout(null);
            b.setFocusPainted(false);
            b.setBackground(Color.white);
            b.setContentAreaFilled(true);
        }
        buttons[0].setBounds(25, 25, 150, 25);
        buttons[1].setBounds(225, 25, 150, 25);
        buttons[2].setBounds(25, 60, 150, 25);
        buttons[3].setBounds(225, 60, 150, 25);
        buttons[4].setBounds(25, 95, 150, 25);
        buttons[5].setBounds(225, 95, 150, 25);
        // Projects
        this.projects = new Project[_projects.length];
        System.arraycopy(_projects, 0, this.projects, 0, this.projects.length);
        // Panel
        this.panel = new JPanel();
        this.panel.setLayout(null);
        for (JButton b : this.buttons)
        {
            b.setVisible(true);
            b.setText("");
            this.panel.add(b);
        }
        this.panel.add(this.previousPage);
        this.panel.add(this.nextPage);
        this.panel.setMaximumSize(this.dimensions);
        this.setContentPane(panel);
    }

    public void showPage(int id)
    {
        if (id >= this.projects.length / 6 - 1 || id < 0)
            return;
        this.pageID = id;
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
            else b.setVisible(false);
            if (!this.previousPageExists())
                this.previousPage.setVisible(false);
            else this.previousPage.setVisible(true);
            if (!this.nextPageExists())
                this.nextPage.setVisible(false);
            else this.nextPage.setVisible(true);
            i++;
        }
    }

    public boolean previousPageExists()
    {
        return !(this.pageID - 1 < 0);
    }

    public boolean nextPageExists()
    {
        return !(this.pageID >= this.projects.length / 6 - 1);
    }
}
