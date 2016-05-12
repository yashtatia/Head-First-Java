public class Foo
{
    public void go()
    {
        Laundary laundary=new Laundary();
        try
        {
            laundary.doLaundary();
        }catch(PantsException pex){
            //recovery code
        }catch(LingerieException lex){
            //recovery code
        }
    }
}