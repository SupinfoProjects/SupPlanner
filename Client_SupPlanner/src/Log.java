import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Log extends JFrame implements ActionListener
{
    //Création des éléments
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
        this.setSize(350, 300);
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
        Dimension dim = new Dimension(160, 20);
        mail.setPreferredSize(dim);
        pass.setPreferredSize(dim);

        //Positionnement des éléments
        //Logo
        grid.insets = new Insets(5,5,5,5);
        grid.ipady = 10;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.fill = GridBagConstraints.VERTICAL;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(cont, grid);
        //email
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
        //password
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
        //boutons
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
            //sockets connection login et mot de passe
            Socket socket;
            BufferedReader in;
            PrintWriter out;
            String email = mail.getText();
            String password = pass.getText();
            try {
                socket = new Socket(InetAddress.getLocalHost(), 8080);
                System.out.println("Demande de connexion");
                out = new PrintWriter(socket.getOutputStream());
                out.println("login");
                out.println(email);
                out.println(password);
                out.flush();
                in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                String response = in.readLine();
                System.out.println(response);
                if (response.equals("true")){
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
                else{
                    //erreur de login ou mdp
                    JOptionPane.showMessageDialog(panel,
                            "Votre identifiant ou mot de passe est invalide veuillez réessayer.",
                            "Erreur",
                            JOptionPane.WARNING_MESSAGE);
                    mail.setText("");
                    pass.setText("");
                    Log login;
                    login = new Log();
                }
                socket.close();
            }catch (UnknownHostException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }

        this.dispose();
    }
}
