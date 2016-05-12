import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox2
{
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    
    String[] instrumentNames={"Bass Drum", "Closed Hi-Hat",
        "Open Hi-Hat", "Acoustic Snare","Crash Cymbal","Hand Clap",
        "High Tom", "Hi Bongo", "Marcas", "Whistle","Low Conga", 
        "Cowbell", "Vibraslap","Low-mid Tom","High Agogo",
        "Open Hi Conga"};
    int[] instruments={35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
    
    public static void main(String[] args)
    {
        BeatBox2 gui=new BeatBox2();
        gui.buildGUI();
    }
    
    public void buildGUI()
    {
        theFrame=new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout=new BorderLayout();
        JPanel background=new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        checkboxList=new ArrayList<JCheckBox>();
        Box buttonBox=new Box(BoxLayout.Y_AXIS);
        
        JButton start=new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        
        JButton stop=new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);
        
        JButton upTempo=new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);
        
        JButton downTempo=new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);
        
        Box nameBox=new Box(BoxLayout.Y_AXIS);
        for(int i=0;i<16;i++)
        {
            nameBox.add(new Label(instrumentNames[i]));
        }
        
        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);
        
        theFrame.getContentPane().add(background);
        
        GridLayout grid=new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel=new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);
        
        for(int i=0;i<256;i++)
        {
            JCheckBox c=new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }
        
        setUpMidi();
        
        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        //*The pack method sizes the frame so that all its contents are at or above their preferred sizes. 
        // * An alternative to pack is to establish a frame size explicitly by calling setSize or setBounds (which also sets the frame location). 
        // * In general, using pack is preferable to calling setSize, since pack leaves the frame layout manager in charge of the frame size, 
        // * and layout managers are good at adjusting to platform dependencies and other factors that affect component size.
         
        theFrame.setVisible(true);
         
    }
    
    public void setUpMidi()
    {
        try
        {
            sequencer=MidiSystem.getSequencer();
            sequencer.open();
            sequence=new Sequence(Sequence.PPQ,4);
            track=sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void buildTrackAndStart()
    {
        int[] trackList=null;
        
        sequence.deleteTrack(track);
        track=sequence.createTrack();
        
        for(int i=0;i<16;i++)
        {
            trackList=new int[16];
            
            int key=instruments[i];
            
            for(int j=0;j<16;j++)
            {
                JCheckBox jc=(JCheckBox)checkboxList.get(j+(16*i));
                if(jc.isSelected())
                {
                    trackList[j]=key;
                }
                else
                {
                    trackList[j]=0;
                }
            }
            
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }
        
        track.add(makeEvent(192,9,1,0,15));
        try
        {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    public class MyStartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            buildTrackAndStart();
        }
    }
    
    public class MyStopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            sequencer.stop();
        }
    }
    
    public class MyUpTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            float tempoFactor=sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*1.03));
        }
    }
    
    
    public class MyDownTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            float tempoFactor=sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*.97));
        }
    }
    
    public void makeTracks(int[] list)
    {
        for(int i=0;i<16;i++)
        {
            int key=list[i];
            
            if(key!=0)
            {
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }
    }
    
    public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick)
    {
        MidiEvent event=null;
        try
        {
            ShortMessage a=new ShortMessage();
            a.setMessage(cmd,chan,one,two);
            event=new MidiEvent(a,tick);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return event;
    }
}
/**here is the full story for Java HeadFirst Readers. It might help you in case you too got this warning : 

*Especially with Windows 7, the JVM has not by default the permission to write into the Windows registry where the backing store for java.util.prefs.preferences is located under MS-Windows. 
*When executing either the ReverseXSL transformer, or even the Regex tester program, one can get errors like: Could not open/create prefs root node Software\JavaSoft\Prefs at root 0x80000002. Windows RegCreateKeyEx 
*This does prevent registering a license. It does not prevent the software to perform transformations in the free software mode. 
*Fixing the issue is simply a matter of granting the necessary permissions to the registry root key at stake. 
*Run regedit.exe as administrator (regedit.exe is located in the c:\Windows operating system root directory). 
*Go to key HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Prefs. 
*Right click to set permissions. Check a mark in the Full Control check box for the user(s) that need executing the reverseXSL software.
*/