public class TestExceptions{
    
    public static void main(String[] args)
    {
        string test="no";
        
        try{
            System.out.println("start try");
            doRisky(test);
            System.out.println("End try");
            
        }catch(ScaryException se){
            System.out.println("Scary Exception");
            
        }finally{
            System.out.println("finally");
        }
        System.out.println("End of main");
    }
    
    static void doRisky(String test) throws ScaryException{
        System.out.println("start risky");
        if("yes".equals(test)){
            throw new ScaryException();
        }
        System.out.println("end risky");
        return;
    
    }
}