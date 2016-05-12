import javax.swing.*;
import java.awt.*;

public class Buttons
{
    public static void main(String[] args)
    {
        Buttons gui= new Buttons();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JButton north=new JButton("north");
        JButton south=new JButton("south");
        JButton east=new JButton("east");
        JButton west=new JButton("west");
        JButton center=new JButton("center");
        
        frame.getContentPane().add(BorderLayout.NORTH,north);
        frame.getContentPane().add(BorderLayout.SOUTH,south);
        frame.getContentPane().add(BorderLayout.EAST,east);
        frame.getContentPane().add(BorderLayout.WEST,west);
        frame.getContentPane().add(BorderLayout.CENTER,center);
        
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}