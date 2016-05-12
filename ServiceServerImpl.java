import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer
{
    HashMap serviceList;
    
    public ServiceServerImpl()throws RemoteException
    {
        setUpService();
    }
    
    private void setUpService()
    {
        serviceList=new HashMap();
        serviceList.put("Dice rolling Service", new DiceService());
        serviceList.put("Day of the week service",new DayOfTheWeekService());
        serviceList.put("VisualMusicService",new MiniMusicService());
    }
    
    public Object[] getServiceList()
    {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }
    
    public Service getService(Object serviceKey) throws RemoteException
    {
        Service theService=(Service)serviceList.get(serviceKey);
        return theService;
    }
    
    public static void main(String[] ags)
    {
        try
        {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println("Remote Service is running");
    }
}