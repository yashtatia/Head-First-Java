import java.io.*;
public class Game
{
    public static void main(String[] args) throws IOException
    {
        int numOfGuesses=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        SimpleDotCom theDotCom=new SimpleDotCom();    
        int randomNum=(int)(Math.random()*5);
        
        int[] locations={randomNum,randomNum+1,randomNum+2};
        theDotCom.setLocationCells(locations);
        boolean isAlive=true;
        
        while(isAlive==true)
        {
            String guess=br.readLine();
            String result=theDotCom.checkYourself(guess);
            numOfGuesses++;
            
            if(result.equals("kill"))
            {
                isAlive=false;
                System.out.println("You took " +numOfGuesses +" guesses");
            }
        }
    }
}