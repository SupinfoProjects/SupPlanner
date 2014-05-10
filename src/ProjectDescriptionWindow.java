import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class ProjectDescriptionWindow extends WindowBase
{
    private JButton backButton;
    private String projectTitle;
    private String projectAuthor;
    private String projectStartDate;
    private String projectEndDate;
    private Font projectTitleFont = new Font("Arial", Font.BOLD, 20);
    private Font authorNameFont = new Font("Arial", Font.BOLD, 15);
    private Font dateFont = new Font("Arial", Font.BOLD | Font.ITALIC, 10);

    public ProjectDescriptionWindow(Project project)
    {
        super(new Dimension(400, 300));
        // Fenêtre
        this.setLocationRelativeTo(null);
        // Project
        this.projectTitle = project.getTitle();
        this.projectAuthor = project.getAuthorName();
        String beginDay = (project.getStartDate().getDate() < 10)
                ? ("0" + Integer.toString(project.getStartDate().getDate()))
                : (Integer.toString(project.getStartDate().getDate()));
        String beginMonth = (project.getStartDate().getMonth() < 10)
                ? ("0" + Integer.toString(project.getStartDate().getMonth()))
                : (Integer.toString(project.getStartDate().getMonth()));
        projectStartDate = beginDay + "/" + beginMonth + "/" + Integer.toString(project.getStartDate().getYear());
        String endDay = (project.getEndDate().getDate() < 10)
                ? ("0" + Integer.toString(project.getEndDate().getDate()))
                : (Integer.toString(project.getEndDate().getDate()));
        String endMonth = (project.getEndDate().getMonth() < 10)
                ? ("0" + Integer.toString(project.getEndDate().getMonth()))
                : (Integer.toString(project.getEndDate().getMonth()));
        this.projectEndDate = endDay + "/" + endMonth + "/" + Integer.toString(project.getEndDate().getYear());
        this.setTitle("Project '" + this.projectTitle + "' - SupPlanner");
        this.projectTitle += "                "; // Sinon le texte est décalé (aucune logique mais osef)
        // Bouton retour
        this.backButton = new JButton("Retour");
        this.backButton.setLayout(null);
        this.backButton.setBounds(30, 250, 100, 20);
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
        // Dates
        JLabel dateTextField = new JLabel();
        dateTextField.setFont(dateFont);
        dateTextField.setText(this.projectStartDate + " - " + this.projectEndDate);
        dateTextField.setBounds(20, 45, 200, 20);
        this.panel.add(dateTextField);
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
