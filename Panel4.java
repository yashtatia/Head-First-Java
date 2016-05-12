import java.awt.*;
import javax.swing.*;

public class Panel4
{
    public static void main(String[] args)
    {
        Panel4 gui=new Panel4();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JButton onebutton=new JButton("Lets rule");
        JButton twobutton=new JButton("Me!!!");
        
        panel.add(onebutton);
        panel.add(twobutton);
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}