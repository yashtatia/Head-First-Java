import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SimpleChatClientA
{
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    public static void main(String[] args)
    {
        SimpleChatClientA gui=new SimpleChatClientA();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel=new JPanel();
        outgoing=new JTextField(20);
        JButton sendButton=new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        setUpNetworking();frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setUpNetworking()
    {
        try
        {
            sock=new Socket("127.0.0.1",5000);
            writer=new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    public class SendButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            try
            { 
                writer.println(outgoing.getText());
                writer.flush();
            }catch(Exception ex){ex.printStackTrace();}
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
}