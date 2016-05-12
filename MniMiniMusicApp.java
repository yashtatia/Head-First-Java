import javax.sound.midi.*;

public class MniMiniMusicApp
{
    public static void main(String[] ags)
    {
        MniMiniMusicApp mini=new MniMiniMusicApp();
        mini.play();
    }
    
    public void play()
    {
        try{
            Sequencer player=MidiSystem.getSequencer();
            player.open();//get a sequencer and open it. they come closed
            
            Sequence seq=new Sequence(Sequence.PPQ,4);//imageine arguments to be ready made 
            
            Track track=seq.createTrack();//asking sequence for a track
            //as track lives in a sequence and midi data lives ina track
            
            ShortMessage a =new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteOn=new MidiEvent(a,1);
            track.add(noteOn);
            
            ShortMessage b =new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff=new MidiEvent(b,16);
            track.add(noteOff);
            
            //MidiEvent code mostly readymade
            
            player.setSequence(seq);
            player.start();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}