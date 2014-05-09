import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Content extends JPanel {
    public void paint(Graphics g){
        try{
            Image img = ImageIO.read(new File("C:\\Users\\aiems_000\\Desktop\\SupPlanner\\src\\supPlanner.png"));
            int middle = this.getWidth()/2 - img.getWidth(null)/2;
            g.drawImage(img, middle, 0, this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
