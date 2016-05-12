import javax.swing.*;

public class SimpleGui1
{
    public static void main(String[] args)
    {
        
        JFrame frame=new JFrame();
        JButton button=new JButton("click me");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes the program close on exit
        
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        //giving frame size in pixels
        frame.setVisible(true);
        //making it visible
    }
}