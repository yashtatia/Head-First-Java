import java.util.*;

public class TestGenerics2
{
    public static void main(String[] args)
    {
        TestGenerics2 obj=new TestGenerics2();
        obj.go();
    } 
    public void go()
    {
        ArrayList<Animal1> animals=new ArrayList<Animal1>();
        animals.add(new Dog1());
        animals.add(new Cat1());
        animals.add(new Dog1());
        takeAnimals(animals);
        
    }
    
    public void takeAnimals(ArrayList<Animal1> animals)
    {
        for(Animal1 a:animals)
        {
            a.eat();
        }
    }
}