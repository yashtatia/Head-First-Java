import java.rmi.*;

public class MyRemoteClient
{
    public static void main(String[] args)
    {
        MyRemoteClient obj=new MyRemoteClient();
        obj.go();
    }
    
    public void go()
    {
        try
        {
            MyRemote service=(MyRemote)Naming.lookup("rmi://12.0.01.1/Remote Hello");
            
            String s=service.sayHello();
            
            System.out.println(s);
        }catch(Exception ex){ex.printStackTrace();}
    }
}