class Book implements Comparable
{
    String title;
    public Book(String t){
        title=t;
    }
    
    public int compareTo(Object b)
    {
        Book book=(Book)b;
        return (title.compareTo(book.title));
    }
}