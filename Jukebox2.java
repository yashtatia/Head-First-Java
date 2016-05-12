import java.util.*;
import java.io.*;

public class Jukebox2
{
    ArrayList<String> songList=new ArrayList<String>();
    
    public static void main(String[] args)
    {
        Jukebox2 sorter=new Jukebox2();
        sorter.go();
    }
    
    public void go()
    {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }
    
    void getSongs()
    {
        try
        {
            File file=new File("SongList.txt");
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
        songList.add(tokens[0]);
    }
}