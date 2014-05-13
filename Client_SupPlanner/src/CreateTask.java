import sun.security.jca.JCAUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CreateTask extends JFrame{
    private JButton create = new JButton("Créer");
    private JLabel name = new JLabel(  "Nom de la tâche :    ");
    private JLabel lBegin = new JLabel("Date de début :         ");
    private JLabel lEnd = new JLabel(  "Date de fin :              ");
    private JLabel lDesc = new JLabel("Description");
    private JTextArea desc = new JTextArea("Entrez ici la description de la tâche.");
    private JTextField nameEntry = new JTextField();


    public CreateTask(){
        this.setSize(350, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        String[] days = {"01", "02", "03","04", "05", "06", "07","08", "09", "10", "11","12", "13", "14", "15","16", "17", "18", "19","20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"};
        String[] hours = {"00h", "01h", "02h", "03h","04h", "05h", "06h", "07h","08h", "09h", "10h", "11h","12h", "13h", "14h", "15h","16h", "17h", "18h", "19h","20h", "21h", "22h", "23h",};
        JComboBox beginD = new JComboBox(days);
        JComboBox beginM = new JComboBox(months);
        JComboBox beginH = new JComboBox(hours);
        JComboBox endD = new JComboBox(days);
        JComboBox endM = new JComboBox(months);
        JComboBox endH = new JComboBox(hours);
        Font police = new Font("Verdana", Font.BOLD, 12);

        Border areaBorder = BorderFactory.createLineBorder(Color.BLACK);
        desc.setSize(150,150);
        desc.setBorder(BorderFactory.createCompoundBorder(areaBorder, BorderFactory.createEmptyBorder(10,10,10,10)));
        desc.setEditable(true);
        desc.setFont(police);
        nameEntry.setFont(police);


        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        nameEntry.setPreferredSize(new Dimension(100, 30));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0;
        gbc.gridy = 0;
        gbc.ipady = 10;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(name,gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(nameEntry,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(lBegin,gbc);
        gbc.gridx=1;
        panel.add(beginD,gbc);
        gbc.gridx=2;
        panel.add(beginM,gbc);
        gbc.gridx=3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(beginH,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(lEnd, gbc);
        gbc.gridx = 1;
        panel.add(endD,gbc);
        gbc.gridx=2;
        panel.add(endM,gbc);
        gbc.gridx=3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(endH,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(desc, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(create, gbc);

        this.setContentPane(panel);
        this.setVisible(true);


    }
}
