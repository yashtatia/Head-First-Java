import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

public class SimpleChatClient1
{
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader br;
    PrintWriter writer;
    Socket sock;
    
    public static void main (String[] args)
    {
        SimpleChatClient1 client=new SimpleChatClient1();
        client.go();
    }
    
    public void go()
    {
        JFrame frame=new JFrame("Simple Chat Client");
        JPanel mainPanel=new JPanel();
        incoming=new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller=new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing=new JTextField(20);
        JButton sendButton=new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();
        
        Thread readerThread=new Thread(new IncomingReader());
        readerThread.start();
        
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setUpNetworking()
    {
        try
        {
            sock=new Socket("127.0.0.1",5000);
            InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
            br=new BufferedReader(streamReader);
            writer=new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }catch(IOException ex){ex.printStackTrace();}
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
    
    public class IncomingReader implements Runnable
    {
        public void run()
        {
            String message;
            try
            {
                while((message=br.readLine())!=null)
                {
                    System.out.println("read " + message);
                    incoming.append(message+ "\n");
                }
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
}