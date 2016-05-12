import java.awt.*;
import javax.swing.*;

public class TextField1
{
    public static void main(String[] args)
    {
        TextField1 gui=new TextField1();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JTextField field=new JTextField(20);
        frame.getContentPane().add(BorderLayout.NORTH,field);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}