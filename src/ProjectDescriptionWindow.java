import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjectDescriptionWindow extends WindowBase
{
    private Project project;
    private JButton backButton;

    public ProjectDescriptionWindow(Project project)
    {
        super(new Dimension(400, 300));
        this.project = project;
    }

    public void display()
    {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
