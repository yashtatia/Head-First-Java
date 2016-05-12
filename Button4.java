import javax.swing.*;
import java.awt.*;

public class Button4
{
    public static void main(String[] args)
    {
        Button4 gui= new Button4();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        JButton button=new JButton("Click me");
        Font bigFont=new Font("serif",Font.BOLD,28);
        button.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH,button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}