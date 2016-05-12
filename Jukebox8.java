import java.util.*;
import java.util.ArrayList.*;
import java.io.*;

public class Jukebox8
{
    ArrayList<Song> songList=new ArrayList<Song>();
    
    public static void main(String[] args)
    {
        Jukebox8 sorter=new Jukebox8();
        sorter.go();
    }
    
    class ArtistCompare implements Comparator<Song>
    {
        public int compare(Song one, Song two)
        {
            return one.getArtist().compareTo(two.getArtist());
        }
    }
    
    public void go()
    {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        
        TreeSet<Song> songSet=new TreeSet<Song>();
        songSet.addAll(songList);
        System.out.println(songList);
    }
    
    void getSongs()
    {
        try
        {
            File file=new File("SongListMore.txt");
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=br.readLine())!=null)
            {
                addSong(line);
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    void addSong(String lineToParse)
    {
        String[] tokens=lineToParse.split("/");
        
        Song nextSong=new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        songList.add(nextSong);
    }
}