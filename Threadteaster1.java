class Threadteaster1
{
    public static void main(String[] args)
    {
        Runnable threadJob=new MyRunnable1();
        Thread myThread=new Thread(threadJob);
        myThread.start();
        System.out.println("back in main");
    }
}