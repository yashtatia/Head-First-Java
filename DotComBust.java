import java.util.ArrayList;
public class DotComBust
{
    private GameHelper gh=new GameHelper();
    private ArrayList<DotCom> dotComList=new ArrayList<DotCom>();
    private int numOfGuesses=0;
    
    public void setUpGame()
    {
        
        //make some dotcoms and give them lcation
        DotCom one=new DotCom();
        one.setName("Pets.com");
        DotCom two=new DotCom();
        one.setName("eToys.com");
        DotCom three=new DotCom();
        one.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        
        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in few no.of guesses");
        
        for(DotCom dotComToSet: dotComList)
        {

            ArrayList<String> newLocation=gh.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    
    private void startPlaying()
    {
        while(!dotComList.isEmpty())
        {
            String userGuess=gh.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }     
    
    private void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result="miss";
        for(DotCom dotComToTest: dotComList)
        {
            result=dotComToTest.checkYourself(userGuess);
            if(result.equals("hit"))
            break;
            if(result.equals("kill"))
            {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    
    private void finishGame()
    {
        System.out.println("All Dot Coms are dead, Your stocks are now worthless");
        if(numOfGuesses<=18)
        {
            System.out.println("It took you "+numOfGuesses+ " guesses");
            System.out.println("You got out before u're options sank");
        }
        else
        {
            System.out.println("Took u long enough. "+ numOfGuesses+" guesses");
            System.out.println("Fish are dancing with u're options");
        }
    }
    
    public static void main (String[] args)
    {
        DotComBust game=new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
    
}
