import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

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
        // Bouton retour
        this.backButton = new JButton("Retour");
        this.backButton.setLayout(null);
        this.backButton.setBounds(10, 250, 100, 20);
        this.backButton.addActionListener(this);
        this.panel.add(this.backButton);
    }

    public void display()
    {
        // Titre du project
        JLabel titleTextField = new JLabel();
        titleTextField.setFont(projectTitleFont);
        titleTextField.setText(projectTitle);
        titleTextField.setBounds(10, 10, 300, 20);
        this.panel.add(titleTextField);
        // Auteur
        JLabel authorNameTextField = new JLabel();
        authorNameTextField.setFont(authorNameFont);
        authorNameTextField.setText("Auteur : " + projectAuthor);
        authorNameTextField.setBounds(20, 30, 100, 20);;
        this.panel.add(authorNameTextField);
        // Bouton retour
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == this.backButton)
        {
            Dimension size = new Dimension(1280, 720);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            // TODO - Récupérer projets depuis BDD
            Project[] array = new Project[50];
            for (int i = 0; i < 50; i++)
                try {
                    array[i] = new Project("super" + Integer.toString(i), "toto", new Date(2014, 5, 10), new Date(2015, 12, 25));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            Projectdash projectdash = new Projectdash(new Point(screenSize.width / 2 - size.width / 2,
                    screenSize.height / 2 - size.height / 2), array);
            projectdash.showPage(0);
            this.dispose();
        }
    }
}
