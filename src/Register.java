import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Register extends JFrame implements ActionListener{
    private JButton register_button = new JButton("S'inscrire");
    private JButton back = new JButton("Retour");
    private Content cont = new Content();
    private JTextField mail = new JTextField();
    private JTextField name = new JTextField();
    private JPasswordField pass;
    private JPasswordField pass2;
    private JRadioButton b1 = new JRadioButton("Manager");
    private JRadioButton b2 = new JRadioButton("Employé");
    private JLabel label = new JLabel("  Votre Nom :        ");
    private JLabel label1 = new JLabel("  Votre addresse email :");
    private JLabel label2 = new JLabel("  Mot de passe :               ");
    private JLabel label3 = new JLabel("  Confirmation :                ");
    private JPanel panel = new JPanel();
    public Register(){
        pass = new JPasswordField(8);
        pass.addActionListener(this);
        pass2 = new JPasswordField(8);
        pass2.addActionListener(this);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        //Initialisation du layout de la fenetre
        panel.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        Font police = new Font("Arial",Font.BOLD, 14);
        Dimension dim = new Dimension(160, 20);
        mail.setFont(police);
        cont.setPreferredSize(new Dimension(100,100));
        mail.setPreferredSize(dim);
        pass.setPreferredSize(dim);
        pass2.setPreferredSize(dim);

        ButtonGroup usertype = new ButtonGroup();

        usertype.add(b1);
        usertype.add(b2);
        b1.setSelected(true);

        //Logo
        grid.insets = new Insets(5,5,5,5);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.ipady = 5;
        grid.fill = GridBagConstraints.VERTICAL;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(cont, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(name, grid);

        //email
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label1, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(mail, grid);
        //password
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label2, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(pass, grid);
        //vérification
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(label3, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(pass2, grid);
        //Employé ou Manager
        grid.gridx = 0;
        grid.gridy = 5;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(b1, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(b2, grid);
        //Boutons
        grid.gridx = 0;
        grid.gridy = 6;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.fill = GridBagConstraints.VERTICAL;
        panel.add(register_button, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(back, grid);

        back.addActionListener(this);
        register_button.addActionListener(this);
        this.setContentPane(panel);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == this.register_button){
            this.registerNewMember();
            Socket socket;
            BufferedReader in;
            PrintWriter out;
            String email = mail.getText();
            char[] password = pass.getPassword();
            String pass = new String(password);
            String nameString = name.getText();
            String usertype = null;
            if (b1.isSelected())
            {
                usertype = "Manager";
            }
            else if (b2.isSelected())
            {
                usertype = "Employé";
            }

            try {
                socket = new Socket(InetAddress.getLocalHost(), 8080);
                System.out.println("Demande de connexion");
                out = new PrintWriter(socket.getOutputStream());
                out.println("register");
                out.println(nameString);
                out.println(email);
                out.println(password);
                out.println(usertype);
                out.flush();
                in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                String response = in.readLine();
                if (response.equals("true")){
                    System.out.println("Compte créé.");
                }
                else{
                    System.out.println("Une erreur est survenue.");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (arg0.getSource() == this.back){
            Log login = new Log();
            this.dispose();
        }



    }

    private void registerNewMember() {
        char[] cPass = pass.getPassword();
        char[] cPass2 = pass2.getPassword();
        String mailText = mail.getText();
        String password1 = new String(cPass);
        String password2 = new String(cPass2);
        int upperCount = 0;
        int numberCount = 0;

        for (int i=0 ; i < password1.length() ; i++){
            if(cPass[i] == Character.toUpperCase(cPass[i]) ){
                upperCount++;
            }
            if(Character.isDigit(cPass[i])){
                numberCount++;
            }
        }
        if (!Mail.isValid(mailText)){
            JOptionPane.showMessageDialog(panel,
                    "Addresse email invalide, veuillez entrer une addresse supinfo (@supinfo.com).",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            Register wreg = new Register();
        }
        else if (password1.length()<8){
            JOptionPane.showMessageDialog(panel,
                    "Votre mot de passe est trop court, veuillez entrer un mot de passe d'au moins 8 caractères.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            Register wreg = new Register();
        }
        else if (upperCount == 0 || numberCount == 0){
            JOptionPane.showMessageDialog(panel,
                    "Votre mot de passe doit contenir au moins une majuscule et un chiffre.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            Register wreg = new Register();
        }
        else if (!password1.equals(password2)){
            JOptionPane.showMessageDialog(panel,
                    "Vos deux mots de passe ne correspondent pas.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            Register wreg = new Register();
        }
        else {
            JOptionPane.showMessageDialog(panel, "Compte créé.");
            Log Login = new Log();
            this.dispose();
        }
    }
}
