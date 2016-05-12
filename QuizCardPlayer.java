import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList.*;

public class QuizCardPlayer
{
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;
    
    public static void main(String[] args)
    {
        QuizCardPlayer gui=new QuizCardPlayer();
        gui.go();
    }
    
    public void go()
    {
        //build gui
        
        frame =new JFrame("Quiz Card Player");
        JPanel mainPanel=new JPanel();
        Font bigFont=new Font("sanserif",Font.BOLD,24);
        
        display=new JTextArea(10,20);
        display.setFont(bigFont);
        
        display.setLineWrap(true);
        display.setEditable(false);
        
        JScrollPane qScroller=new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        nextButton=new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        
        JMenuBar menuBar=new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        JMenuItem loadMenuItem=new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class NextCardListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(isShowAnswer)
            {
                //Show the answer becoz they have seen the Q
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer=false;
            }
            else
            {
                //show the next Q
                display.setText("That was the last Card");
                nextButton.setEnabled(false);
            }
        }
    }
    
    public class OpenMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            JFileChooser fileOpen=new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    
    private void loadFile(File file)
    {
        cardList=new ArrayList<QuizCard>();
        try
        {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=br.readLine())!=null)
            {
                makeCard(line);
            }
            br.close();
        }catch(Exception ex)
        {
            System.out.println("Couldn't read the card file");
            ex.printStackTrace();
        }
        //now time to starrt by showing the first card
        showNextCard();
    }
    
    public void makeCard(String lineToParse)
    {
        String[] result=lineToParse.split("/");
        QuizCard card=new QuizCard(result[0],result[1]);
        cardList.add(card);
        System.out.println("make a word");
    }
    
    public void showNextCard()
    {
        currentCard= cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer=true;
    }
}

