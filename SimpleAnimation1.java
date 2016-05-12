import javax.swing.*;
import java.awt.*;

public class SimpleAnimation1
{
    int x=70,y=70;
    public static void main(String[] args)
    {
        SimpleAnimation1 gui= new SimpleAnimation1();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyDrawPanel obj=new MyDrawPanel();
        
        frame.getContentPane().add(obj);
        frame.setSize(300,300);
        frame.setVisible(true);
        
        for(int i=0;i<130;i++)
        {
            x++;
            y++;
            
            obj.repaint();
            
            try
            {
                Thread.sleep(50);
            }catch(Exception ex){}
            
        }
    }
    
    class MyDrawPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x,y,40,40);

        }
        
    }
}