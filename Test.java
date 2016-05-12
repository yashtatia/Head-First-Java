import java.util.*;
class Test
{
    public void go()
    {
        Book b1=new Book("How cats work");
        Book b2=new Book("Remix your body");
        Book b3=new Book("Finding emo");
        
        BookCompare bCompare=new BookCompare();
        TreeSet<Book> tree=new TreeSet<Book>(bCompare);
        
        tree.add(new Book("How cats work"));
        tree.add(new Book("Remix your body"));
        tree.add(new Book("Finding emo"));
    }
}