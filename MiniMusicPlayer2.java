import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener
{
    public static void main(String[] args)
    {
        MiniMusicPlayer2 mini=new MiniMusicPlayer2();
        mini.go();
    }
    
    public void go()
    {
        try
        {
            Sequencer sequencer=MidiSystem.getSequencer();
            sequencer.open();
            
            int[] eventIWant={127};
            sequencer.addControllerEventListener(this,eventIWant);
            
            Sequence seq=new Sequence(Sequence.PPQ,4);
            Track track=seq.createTrack();
            
            for(int i=5;i<60;i+=4)
            {
                track.add(makeEvent(144,1,i,100,i));
                
                track.add(makeEvent(176,1,127,0,i));
            }
            
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(22);
            sequencer.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void controlChange(ShortMessage event)
    {
        System.out.println("la");
    }
    
    public MidiEvent makeEvent(int cmd,int chan,int one,int two, int tick)
    {
        MidiEvent event=null;
        try
        {
            ShortMessage a=new ShortMessage();
            a.setMessage(cmd,chan,one,two);
            event=new MidiEvent(a, tick);
        }catch(Exception ex){}
        return event;
    }
}