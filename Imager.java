import javax.swing.*;
import java.awt.*;

public class Imager extends JPanel
{
    public void paintComponent(Graphics g)
    {
        Image image=new ImageIcon("IMG_0382.jpg").getImage();
        g.drawImage(image,3,4,this);
    }
    
    public static void main(String[] args)
    {
        JFrame frame =new JFrame("Naruto");
        frame.add(new Imager());
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}