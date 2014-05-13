import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Content extends JPanel {
    public void paint(Graphics g){
	URL imgUrl = this.getClass().getResource("supPlanner.png");
        try{
            Image img = ImageIO.read(new File(imgUrl));
            int middle = this.getWidth()/2 - img.getWidth(null)/2;
            g.drawImage(img, middle, 0, this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
