import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Projectdash extends BaseWindow
{
    private JButton[] buttons;
    private JButton previousPageButton, nextPageButton, admin, back;
    private Project[] projects;
    private int pageID;

    public Projectdash(Point _location, Project[] _projects)
    {
        super(new Dimension(400, 300));
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
        previousPageButton = new JButton("<");
        previousPageButton.setContentAreaFilled(false);
        previousPageButton.setLayout(null);
        previousPageButton.setFocusPainted(false);
        previousPageButton.setBackground(Color.white);
        previousPageButton.setContentAreaFilled(true);
        previousPageButton.setBounds(10, this.dimensions.height - 50, 50, 20);
        previousPageButton.setVisible(true);
        previousPageButton.addActionListener(this);
        // Next page
        nextPageButton = new JButton(">");
        nextPageButton.setContentAreaFilled(false);
        nextPageButton.setLayout(null);
        nextPageButton.setFocusPainted(false);
        nextPageButton.setBackground(Color.white);
        nextPageButton.setContentAreaFilled(true);
        nextPageButton.setBounds(340, this.dimensions.height - 50, 50, 20);
        nextPageButton.setVisible(true);
        nextPageButton.addActionListener(this);
        // Buttons
        for (JButton b : this.buttons)
        {
            b.setContentAreaFilled(false);
            b.setLayout(null);
            b.setFocusPainted(false);
            b.setBackground(Color.white);
            b.setContentAreaFilled(true);
        }
        buttons[0].setBounds(25,  25, 150, 25);
        buttons[1].setBounds(225, 25, 150, 25);
        buttons[2].setBounds(25,  60, 150, 25);
        buttons[3].setBounds(225, 60, 150, 25);
        buttons[4].setBounds(25,  95, 150, 25);
        buttons[5].setBounds(225, 95, 150, 25);
        // Projects
        this.projects = new Project[_projects.length];
        System.arraycopy(_projects, 0, this.projects, 0, this.projects.length);
        // Panel
        for (JButton b : this.buttons)
        {
            b.setVisible(true);
            b.setText("");
            this.panel.add(b);
        }
        this.panel.add(this.previousPageButton);
        this.panel.add(this.nextPageButton);
    }

    public void showPage(int id)
    {
        this.pageID = id;
        for (int i = id * 6; i < this.buttons.length + id * 6; i++)
        {
            if (i < this.projects.length)
            {
                String text = this.projects[i].getTitle().length() > 7
                        ? this.projects[i].getTitle().substring(0, 7) + "..."
                        : this.projects[i].getTitle();
                this.buttons[i - id * 6].setText(text);
                this.buttons[i - id * 6].setVisible(true);
            }
            else this.buttons[i - id * 6].setVisible(false);
            if (!this.previousPageExists())
                this.previousPageButton.setVisible(false);
            else this.previousPageButton.setVisible(true);
            if (!this.nextPageExists())
                this.nextPageButton.setVisible(false);
            else this.nextPageButton.setVisible(true);
        }
    }

    public boolean previousPageExists()
    {
        return !(this.pageID - 1 < 0);
    }

    public boolean nextPageExists()
    {
        return !(this.pageID >= this.projects.length / 6 );
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == this.previousPageButton)
        {
            --this.pageID;
            this.showPage(this.pageID);
        }
        else if (event.getSource() == this.nextPageButton)
        {
            ++this.pageID;
            this.showPage(this.pageID);
        }
    }
}
