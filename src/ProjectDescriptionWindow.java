import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjectDescriptionWindow extends WindowBase
{
    private JButton backButton;
    private String projectTitle;
    private String projectAuthor;
    private Font projectTitleFont = new Font("Arial", Font.BOLD, 20);
    private Font authorNameFont = new Font("Arial", Font.BOLD, 15);

    public ProjectDescriptionWindow(Project project)
    {
        super(new Dimension(400, 300));
        // Fenêtre
        this.setLocationRelativeTo(null);
        // Project
        this.projectTitle = project.getTitle();
        this.projectAuthor = project.getAuthorName();
        this.setTitle("Project '" + this.projectTitle + "' - SupPlanner");
        this.projectTitle += "                "; // Sinon le texte est décalé (aucune logique mais osef)
        this.display();
    }

    public void display()
    {
        // Titre du project
        JLabel titleTextField = new JLabel();
        titleTextField.setFont(projectTitleFont);
        titleTextField.setText(projectTitle);
        titleTextField.setBounds(10, 10, 300, 20);;
        this.panel.add(titleTextField);
        // Auteur
        JLabel authorNameTextField = new JLabel();
        authorNameTextField.setFont(authorNameFont);
        authorNameTextField.setText("Auteur : " + projectAuthor);
        authorNameTextField.setBounds(20, 30, 100, 20);;
        this.panel.add(authorNameTextField);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
