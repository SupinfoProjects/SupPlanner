import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.*;

public class Taskdash extends JFrame {
    private JPanel panel = new JPanel();

    public Taskdash(Point location){

        this.setLocation(location);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SupPlanner");
        this.setResizable(false);
        this.setSize(1280, 720);
        Object [][] data = {
                {"Glandage", "8h", "12h", "Wossam", "", ""},
                {"Glandage", "8h", "12h", "Molluscondre", "Ne rien faire", "En cours"}
                //{}
        };
        String title[] = {"Nom", "Date de début", "Date de fin", "Auteur", "Description", "Status"};
        JTable tab = new JTable(data, title);
        this.getContentPane().add(new JScrollPane(tab));
        this.setVisible(true);
    }
}