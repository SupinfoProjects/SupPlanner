import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Log extends JFrame implements ActionListener
{
    private JButton login = new JButton("Se connecter");
    private JButton register = new JButton("S'inscrire");
    private JPanel panel = new JPanel();
    private JTextField mail = new JTextField();
    private JTextField pass = new JPasswordField();
    private JLabel label1 = new JLabel("  Votre addresse email :");
    private JLabel label2 = new JLabel("  Votre mot de passe :");
    private Content cont = new Content();

    public Log()
    {
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        panel.setLayout(new GridBagLayout());
        cont.setPreferredSize(new Dimension(100, 100));
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        Font police = new Font("Arial",Font.BOLD, 14);
        mail.setFont(police);
        Dimension dim = new Dimension(100, 20);
        mail.setPreferredSize(dim);
        pass.setPreferredSize(dim);

        grid.insets = new Insets(5,5,5,5);
        grid.ipady = 10;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.fill = GridBagConstraints.VERTICAL;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(cont, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label1,grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(mail,grid);

        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label2,grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(pass,grid);

        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(register,grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(login,grid);

        register.addActionListener(this);
        login.addActionListener(this);

        this.setContentPane(panel);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent arg0)
    {
        if (arg0.getSource() == this.register)
        {
            Register wreg = new Register();
        }
        else if (arg0.getSource() == this.login)
        {
            Dimension size = new Dimension(1280, 720);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            // TODO - Récupérer projets depuis BDD
            Project[] array = new Project[50];
            for (int i = 0; i < 50; i++)
                try
                {
                    // TODO - Corriger ce bordel
                    CustomDate date =  new CustomDate("05/05/2014");
                    array[i] = new Project("super" + Integer.toString(i), "toto", date, new CustomDate("25/11/2015"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            Projectdash wtask = new Projectdash(new Point(screenSize.width / 2 - size.width / 2,
                    screenSize.height / 2 - size.height / 2), array);
            wtask.showPage(0);
            this.dispose();
        }

        this.dispose();
    }
}
