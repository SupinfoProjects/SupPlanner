import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taskdash extends JFrame implements ActionListener
{
    private JPanel panel = new JPanel();
    private JButton modify = new JButton("Modifier");
    private JButton create = new JButton("Créer");
    private Content cont = new Content();
    
    public Taskdash(Point location)
    {
        this.setLocation(location);
        cont.setPreferredSize(new Dimension(100,100));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        this.setSize(720, 720);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // String columnName[] = {"Nom", "Date de début", "Date de fin", "Auteur", "Description", "Status"};
        /*Object [][] data = {
                {"Glandage", "8h", "12h", "Wossam", "", ""},
                {"Glandage", "8h", "12h", "Molluscondre", "Ne rien faire", "En cours"}
                //{}
        };*/

        JCheckBox check = new JCheckBox();
        DefaultTableModel model = new DefaultTableModel();
        JTable tab = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Date de début");
        model.addColumn("Date de fin");
        model.addColumn("Auteur");
        model.addColumn("Description");
        model.addColumn("Status");
        model.addRow(new Object[]{"Glandage", "8h", "12h", "Molluscondre", "Ne rien faire", "En cours"});

        JScrollPane scroll = new JScrollPane(tab);
        scroll.setPreferredSize( new Dimension(550,500));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(cont ,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(modify, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(create, gbc);

        modify.addActionListener(this);
        create.addActionListener(this);
        this.setContentPane(panel);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent arg0)
    {
        if (arg0.getSource() == this.modify)
        {

        }
        else if (arg0.getSource() == this.create)
        {
            CreateTask newTask = new CreateTask();
        }
    }
}
