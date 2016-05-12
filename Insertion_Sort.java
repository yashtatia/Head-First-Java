public class Insertion_Sort
{
    public static void main(String args[])
    {
        int i,j,key;
        int A[]={0,6,7,3,9,14,90,-7,56};
        //My Attempt
        for(j=1;j<A.length;j++)
        {
            i=j-1;
            while(A[i+1]<A[i]&&i>=0)
            {
                key=A[i+1];
                A[i+1]=A[i];
                A[i]=key;
                i--;
                if(i<0)
                break;
            }
        }
        for(i=0;i<A.length;i++)
        System.out.println(A[i]);
        //or
        for(j=1;j<A.length;j++)
        {
            key=A[j];
            i=j-1;
            while(i>=0&&A[i]>key)
            {
                A[i+1]=A[i];
                i--;
                A[i+1]=key;
            }
        }
        for(i=0;i<A.length;i++)
        System.out.println(A[i]);
    }    
}
