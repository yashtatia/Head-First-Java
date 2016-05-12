class Song implements Comparable<Song>
{
    String title;
    String artist;
    String rating;
    String bpm;
    
     public boolean equals(Object aSong1)
    {
        Song s=(Song)aSong1;
        return getTitle().equals(s.getTitle());
    }
    
    public int hashCode()
    {
        return title.hashCode();
    }
    
    public int compareTo(Song s)
    {
        return title.compareTo(s.getTitle());
    }
    
    Song(String t,String a,String r,String b)
    {
        title=t;
        artist=a;
        rating=r;
        bpm=b;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public String getRating()
    {
        return rating;
    }
    
    public String getBpm()
    {
        return bpm;
    }
    
    public String toString()
    {
        return title;
    }
}