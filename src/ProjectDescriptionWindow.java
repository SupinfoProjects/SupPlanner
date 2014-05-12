import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjectDescriptionWindow extends WindowBase
{
    private JButton backButton;
    private JButton taskButton;
    private String projectTitle;
    private String projectAuthor;
    private String projectStartDate;
    private String projectEndDate;
    private JProgressBar progressBar;
    private Font projectTitleFont = new Font("Arial", Font.BOLD, 20);
    private Font authorNameFont = new Font("Arial", Font.BOLD, 15);
    private Font defaultFont = new Font("Arial", Font.BOLD | Font.ITALIC, 10);

    public ProjectDescriptionWindow(Project project)
    {
        super(new Dimension(400, 300));
        // Fenêtre
        this.setLocationRelativeTo(null);
        // Project
        this.projectTitle = project.getTitle();
        this.projectAuthor = project.getAuthorName();
        projectStartDate = project.getStartDate().toString();
        this.projectEndDate = project.getEndDate().toString();
        this.setTitle("Project '" + this.projectTitle + "' - SupPlanner");
        this.projectTitle += "                "; // Sinon le texte est décalé (aucune logique mais osef)
        // Bouton retour
        this.backButton = new JButton("Retour");
        this.taskButton = new JButton("Tâches");
        this.backButton.setLayout(null);
        this.taskButton.setLayout(null);
        this.backButton.addActionListener(this);
        this.taskButton.addActionListener(this);
        this.backButton.setBounds(10, 230, 120, 20);
        this.taskButton.setBounds(10, 200, 120, 20);
        this.panel.add(this.backButton);
        this.panel.add(this.taskButton);
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
        authorNameTextField.setBounds(20, 30, 100, 20);
        this.panel.add(authorNameTextField);
        // Dates
        JLabel dateTextField = new JLabel();
        dateTextField.setFont(defaultFont);
        dateTextField.setText(this.projectStartDate + " - " + this.projectEndDate);
        dateTextField.setBounds(20, 45, 200, 20);
        this.panel.add(dateTextField);
        // ProgressBar
        int completedTasks = 0;
        for (Task t : project.getTasks())
            if (t.isComplete()) completedTasks++;
        int progress = project.getTasks().length == 0
                ? 0 // Pour éviter de lever une exception si pas de tâches
                : completedTasks * 100 / project.getTasks().length;
        this.progressBar = new JProgressBar(progress);
        this.progressBar.setLayout(null);
        this.progressBar.setBounds(180, 230, 170, 20);
        this.panel.add(this.progressBar);
        JLabel progressText = new JLabel();
        progressText.setFont(defaultFont);
        progressText.setText(Integer.toString(progress) + "%");
        progressText.setBounds(360, 230, 30, 20);
        this.panel.add(progressText);
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
                    array[i] = new Project("super" + Integer.toString(i), "toto", new CustomDate("05/05/2014"), new CustomDate("25/11/2015"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            Projectdash projectdash = new Projectdash(new Point(screenSize.width / 2 - size.width / 2,
                    screenSize.height / 2 - size.height / 2), array);
            projectdash.showPage(0);
            this.dispose();
        }
        else if (event.getSource() == this.taskButton)
        {
            Dimension size = new Dimension(720, 720);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Taskdash wtask = new Taskdash(new Point(screenSize.width / 2 - size.width / 2,
                    screenSize.height / 2 - size.height / 2));
            this.dispose();
        }
    }
}
