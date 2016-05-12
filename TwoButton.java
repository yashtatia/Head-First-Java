import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButton
{
    JFrame frame;
    JLabel label;
    
    public static void main(String[] args)
    {
        TwoButton gui=new TwoButton();
        gui.go();
    }
    
    public void go()
    {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton labelButton=new JButton("Change label");
        labelButton.addActionListener(new LabelListener());
        
        JButton colorButton=new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());
        
        label=new JLabel("I'm a label");
        Random2dPic obj=new Random2dPic();
        
        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, obj);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);
        
        frame.setSize(500,500);
        frame.setVisible(true);
    }
        
        class LabelListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                label.setText("Ouch");
            }
        }
        
        class ColorListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                frame.repaint();
            }
        }
    
}