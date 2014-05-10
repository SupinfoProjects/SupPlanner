import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

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
        this.setSize(350, 110);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        JPanel text = new JPanel();
        text.setLayout(new GridLayout(2,1));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        Font police = new Font("Arial",Font.BOLD, 14);
        mail.setFont(police);
        mail.setPreferredSize(new Dimension(100, 30));
        grid.weightx = 0.5;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 1;
        grid.ipady = 100;
        //panel.add(cont, grid);
        text.add(label1);
        text.add(mail);
        text.add(label2);
        text.add(pass);

        grid.weightx = 0.5;
        grid.gridx = 0;
        grid.gridy = 2;
        panel.add( text, grid);

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 3;
        JPanel insideB = new JPanel();
        insideB.add(register);
        insideB.add(login);
        panel.add(insideB, grid);

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
            Project[] array = new Project[50];
            for (int i = 0; i < 50; i++)
                try {
                    array[i] = new Project("super " + Integer.toString(i), "toto", new Date(2014, 5, 10), new Date(2015, 12, 25));
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
