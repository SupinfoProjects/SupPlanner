import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener{
        private JButton register_button = new JButton("S'inscrire");
        private JButton back = new JButton("Retour");
        private Content cont = new Content();
        private JTextField mail = new JTextField();
        private JPasswordField pass;
        private JPasswordField pass2;
        private JLabel label1 = new JLabel("  Votre addresse email :");
        private JLabel label2 = new JLabel("  Mot de passe :");
        private JLabel label3 = new JLabel("  Confirmation :");
        private JPanel panel = new JPanel();
        public Register(){
            pass = new JPasswordField(8);
            pass.addActionListener(this);
            pass2 = new JPasswordField(8);
            pass2.addActionListener(this);
            this.setSize(400, 200);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setTitle("SupPlanner");
            this.setResizable(false);
            JPanel text = new JPanel();
            text.setLayout(new GridLayout(4,1));
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
            text.add(label3);
            text.add(pass2);
            ButtonGroup usertype = new ButtonGroup();
            JRadioButton b1 = new JRadioButton("Manager");
            JRadioButton b2 = new JRadioButton("Employé");
            usertype.add(b1);
            usertype.add(b2);
            b1.setSelected(true);
            text.add(b1);
            text.add(b2);

            grid.weightx = 0.5;
            grid.gridx = 0;
            grid.gridy = 2;
            panel.add( text, grid);

            grid.fill = GridBagConstraints.HORIZONTAL;
            grid.gridx = 0;
            grid.gridy = 3;
            JPanel insideB = new JPanel();
            insideB.add(register_button);
            insideB.add(back);
            panel.add(insideB, grid);

            back.addActionListener(this);
            register_button.addActionListener(this);
            this.setContentPane(panel);
            this.setVisible(true);




        }
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == this.register_button){
            this.registerNewMember();
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
        }
        else if (password1.length()<8){
            JOptionPane.showMessageDialog(panel,
                    "Votre mot de passe est trop court, veuillez entrer un mot de passe d'au moins 8 caractères.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
        else if (upperCount == 0 || numberCount == 0){
            JOptionPane.showMessageDialog(panel,
                    "Votre mot de passe doit contenir au moins une majuscule et un chiffre.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
        else if (!password1.equals(password2)){
            JOptionPane.showMessageDialog(panel,
                    "Vos deux mots de passe ne correspondent pas.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(panel, "Compte créé.");
            Log Login = new Log();
            this.dispose();
        }
    }
}
