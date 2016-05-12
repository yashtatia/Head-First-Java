import javax.swing.*;
import java.awt.*;

public class Button2
{
    public static void main(String[] args)
    {
        Button2 gui= new Button2();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JButton button=new JButton("Click me like u mean it");//changed the text
        frame.getContentPane().add(BorderLayout.EAST,button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}