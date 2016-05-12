import java.util.*;

public class TestGenerics1
{
    public static void main(String[] args)
    {
        TestGenerics1 obj=new TestGenerics1();
        obj.go();
    } 
    public void go()
    {
        Animal1[] animals={new Dog1(), new Cat1(), new Dog1()};
        Dog1[] dogs={new Dog1(),new Dog1(),new Dog1()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }
    
    public void takeAnimals(Animal1[] animals)
    {
        for(Animal1 a:animals)
        {
            a.eat();
        }
    }
}