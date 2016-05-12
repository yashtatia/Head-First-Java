import java.awt.*;
import javax.swing.*;

public class Panel3
{
    public static void main(String[] args)
    {
        Panel3 gui=new Panel3();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setBackground(Color.darkGray);
        JButton onebutton=new JButton("Lets rule");
        JButton twobutton=new JButton("Me!!!");
        
        panel.add(onebutton);
        panel.add(twobutton);
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}