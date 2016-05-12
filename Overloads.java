public class Overloads
{
    String uniqueId;
    
    public int addNum(int a, int b)
    {
        return a+b;
    }
    
    public double addNum(double a, double b)
    {
        return a+b;
    }
    
    public void setUniqueID(String theID)
    {
        //lots of validation code
        uniqueId=theID;
    }
    
    public void uniqueID(int ssNumber)
    {
        String numString=""+ssNumber;
        setUniqueID(numString);
    }   
}